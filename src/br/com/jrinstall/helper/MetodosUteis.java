/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jrinstall.helper;

import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.net.Inet4Address;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

/**
 *
 * @author Fernando
 */
public class MetodosUteis {

    /**
     * Mostra a mensagem de pergunta
     *
     * @param Mensagem
     * @param titulo
     * @return clique Sim = 0 Clique não = 1
     */
    public static Integer showQuestionMessage(String msg, String titulo) {
        return JOptionPane.showConfirmDialog(null, msg, titulo, 0, 3);
    }

    public static Date ConverteStringToDateMMddyyyy(String valor) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Integer errorOffset = new Integer(1);
        Date valorDate = null;
        try {
            valorDate = (java.util.Date) sdf.parse(valor);
        } catch (ParseException ex) {
            MetodosUteis.showMsg("Data informada é invalida!");
        }

        return valorDate;
    }

    /**
     *
     * @param valor
     * @return Data o formato dd-MM-yyyy
     */
    public static Date ConverteStringToDatedd_MM_yyyy(String valor) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Integer errorOffset = new Integer(1);
        Date valorDate = null;
        try {
            valorDate = (java.util.Date) sdf.parse(valor);
        } catch (ParseException ex) {
            MetodosUteis.showMsg("Data informada é invalida!");
        }

        return valorDate;
    }

    /**
     *
     * @param valor
     * @return Data no formado yyy-MM-dd
     */
    public static Date ConverteStringToDateyyyyMMdd(String valor) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Integer errorOffset = new Integer(1);
        Date valorDate = new Date();
        try {
            valorDate = (java.util.Date) sdf.parse(valor);
        } catch (ParseException ex) {
            MetodosUteis.showMsg("Data informada é invalida!");
        }

        return valorDate;
    }

    public static Double ConverteStringToDoule(String valor) throws Exception {
        Double retorno = 0d;
        try {
            retorno = Double.parseDouble(valor.replace(",", "."));
        } catch (NumberFormatException ex) {
            throw new Exception("Valor informado � invalido!");
        }

        return retorno;
    }

    public static String formataMoeda(double vlr) {
        String r;
        try {
            java.text.DecimalFormat df = new java.text.DecimalFormat("R$ ###,###,##0.00");
            r = df.format(vlr);
        } catch (Throwable ex) {
            r = "0";
        }

        return r;
    }

    public static Double returnDouble(String valor) {
        if (valor.contains(",")) {
            String v = valor.replace(".", "");
            valor = v.replace(",", ".");
        }
        Double retorno = 0d;

        try {
            retorno = Double.valueOf(valor);
        } catch (NumberFormatException ex) {
            MetodosUteis.showMsg("Valor invalido!");
        }

        return retorno;
    }

    public static String returnString(double valor) {
        String retorno = "";
        try {
            retorno = String.valueOf(valor);
        } catch (NumberFormatException ex) {
            MetodosUteis.showMsg("Valor invalido!");
        }

        return retorno;

    }

    public static Long retornaSomenteNumero(String valor) {
        Long retorno;
        try {
            String v = valor.replace(" ", "");
            v = v.replace(".", "");
            v = v.replace("-", "");
            v = v.replace("/", "");
            if (v.isEmpty()) {
                v = "0";
            }
            retorno = Long.parseLong(v);
        } catch (NumberFormatException e) {
            retorno = 0L;
        }
        return retorno;
    }

    public static String getDateNow() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date data = new Date(System.currentTimeMillis());
        String valorDate = new String();

        try {
            valorDate = sdf.format(data);//cal.getTime().toString());
        } catch (IllegalArgumentException e) {
        }
        return valorDate;
    }

    /**
     * Manipula a data conforme o parametro Se parametro for positivo, soma na
     * data atual Se negativo, diminui da data atual
     *
     * @param int numero de dias a manipular
     * @return Date
     */
    public static Date getDataManipulada(int addDay) {
        Calendar cal = new GregorianCalendar();
        cal.add(Calendar.DAY_OF_MONTH, +addDay);
        return cal.getTime();
    }

    public static String FormataDataddMMyyyy(Date valor) {
        String data = null;
        if (null != valor) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            data = sdf.format(valor);
        }
        return data;
    }

    public static Integer getIdade(Date dtNasc) {
        Integer idade;
        GregorianCalendar hj = new GregorianCalendar();
        GregorianCalendar nascimento = new GregorianCalendar();
        if (dtNasc != null) {
            nascimento.setTime(dtNasc);
        }
        int anohj = hj.get(Calendar.YEAR);
        int anoNascimento = nascimento.get(Calendar.YEAR);
        idade = new Integer(anohj - anoNascimento);
        if (nascimento.get(Calendar.MONTH) >= hj.get(Calendar.MONTH)) {
            if (nascimento.get(Calendar.DAY_OF_MONTH) > hj.get(Calendar.DAY_OF_MONTH)) {
                idade--;
            }
        }
        return idade;
    }

    public static void showMsg(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }

    public static boolean campoPreenchido(String nomeCampo, String valor) {
        boolean retorno = true;
        if (null == valor) {
            showMsg("O Campo " + nomeCampo + " é obriatório!");
            retorno = false;
        }

        return retorno;

    }

    /**
     * Através do ip do cliente, ele retorna o macAddress no formato decimal
     *
     * @return mac address no formato decimal
     */
    public static String getMacAddress() {
        StringBuffer macAdrr = new StringBuffer();
        try {
            Inet4Address endereco = (Inet4Address) Inet4Address.getLocalHost();
            NetworkInterface ni = NetworkInterface.getByInetAddress(endereco);

            if (ni != null) {
                byte[] mac = ni.getHardwareAddress();
                if (mac != null) {
                    for (int i = 0; i < mac.length; i++) {
                        //System.out.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : "");
                        macAdrr.append(mac[i]);
                    }
                    //} else {
                    //    MetodosUteis.showMsg("Não foi possivel fazer a idenficação da maquina. Software não autorizado");
                }
                //MetodosUteis.showMsg(macAdrr.toString());
            }

        } catch (UnknownHostException ex) {
        } catch (SocketException ex) {
        }

        return macAdrr.toString();
    }

    public static void HabilitarTextField(JInternalFrame IFrame) {
        Container pn = IFrame.getContentPane();
        for (int i = 0; i < pn.getComponentCount(); i++) {
            //varre todos os componentes
            Component c = pn.getComponent(i);
            if (c instanceof JTabbedPane) {
                JTabbedPane p = (JTabbedPane) c;
                for (int x = 0; x < p.getComponentCount(); x++) {
                    Container comp = (Container) p.getComponent(x);

                    for (int y = 0; y < comp.getComponentCount(); y++) {
                        Component tf = comp.getComponent(y);
                        if (tf instanceof JTextField) {
                            //apaga os valores
                            JTextField field = (JTextField) tf;
                            field.setEditable(true);
                        }

                    }
                }

            } else {
                if (c instanceof JTextField) {
                    //apaga os valores
                    JTextField field = (JTextField) c;
                    field.setEditable(true);
                }
            }
        }
    }

    public static void DesabilitarTextField(JInternalFrame IFrame) {
        Container pn = IFrame.getContentPane();
        for (int i = 0; i < pn.getComponentCount(); i++) {
            //varre todos os componentes
            Component c = pn.getComponent(i);
            if (c instanceof JTabbedPane) {
                JTabbedPane p = (JTabbedPane) c;
                for (int x = 0; x < p.getComponentCount(); x++) {
                    Container comp = (Container) p.getComponent(x);
                    for (int y = 0; y < comp.getComponentCount(); y++) {
                        Component tf = comp.getComponent(y);
                        if (tf instanceof JTextField) {
                            //apaga os valores
                            JTextField field = (JTextField) tf;
                            field.setEditable(false);
                        }

                    }
                }

            } else {
                if (c instanceof JTextField) {
                    //apaga os valores
                    JTextField field = (JTextField) c;
                    field.setEditable(false);
                }
            }
        }
    }

    public static void DefineFontTextField(JInternalFrame IFrame, String font, int style, int size) {
        Container pn = IFrame.getContentPane();
        for (int i = 0; i < pn.getComponentCount(); i++) {
            //varre todos os componentes
            Component c = pn.getComponent(i);
            if (c instanceof JTabbedPane) {
                JTabbedPane p = (JTabbedPane) c;
                for (int x = 0; x < p.getComponentCount(); x++) {
                    Container comp = (Container) p.getComponent(x);
                    for (int y = 0; y < comp.getComponentCount(); y++) {
                        Component tf = comp.getComponent(y);
                        if (tf instanceof JTextField) {
                            //apaga os valores
                            JTextField field = (JTextField) tf;
                            field.setFont(new Font(font, style, size));
                        }

                    }
                }

            } else {
                if (c instanceof JTextField) {
                    //apaga os valores
                    JTextField field = (JTextField) c;
                    field.setEditable(false);
                }
            }
        }
    }

    public static void LimparTextField(JInternalFrame IFrame) {
        Container pn = IFrame.getContentPane();
        for (int i = 0; i < pn.getComponentCount(); i++) {
            //varre todos os componentes
            Component c = pn.getComponent(i);
            if (c instanceof JTabbedPane) {
                JTabbedPane p = (JTabbedPane) c;
                for (int x = 0; x < p.getComponentCount(); x++) {
                    Container comp = (Container) p.getComponent(x);
                    for (int y = 0; y < comp.getComponentCount(); y++) {
                        Component tf = comp.getComponent(y);
                        if (tf instanceof JTextField) {
                            //A paga os valores
                            JTextField field = (JTextField) tf;
                            field.setText("");
                        }
                    }
                }

            } else {
                if (c instanceof JTextField) {
                    //apaga os valores
                    JTextField field = (JTextField) c;
                    field.setText("");
                }
            }
        }
    }
}
