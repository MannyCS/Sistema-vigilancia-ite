package com.example.prototipo_ss;
/*

 * Dentro de esta clase se establece la manera de almacenar un Instancia en vez de ultilizar
 * Intent, para poder mandar infromacion de un lado a otro sin que precupar que abrir la clase
 *

 */
public class DataHolder {

    private static final DataHolder instance = new DataHolder();
    public static DataHolder getInstance() {
        return instance;
    }

    private String data;
    private String data2;
    private String data3;
    private String data4;
    private String data5;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getData2() {
        return data2;
    }

    public void setData2(String data2) {
        this.data2 = data2;
    }

    public String getData3() {
        return data3;
    }

    public void setData3(String data3) {
        this.data3 = data3;
    }

    public String getData4() {
        return data4;
    }

    public void setData4(String data4) {
        this.data4 = data4;
    }

    public String getData5() {
        return data5;
    }

    public void setData5(String data5) {
        this.data5 = data5;
    }


}