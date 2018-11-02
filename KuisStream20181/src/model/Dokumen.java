/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Martin Paramarta / 175314090
 */
public class Dokumen implements Serializable {

    private String isi;

    public Dokumen() {
    }

    public Dokumen(String isi) {
        this.isi = isi;
    }

    public String getIsi() {
        return isi;
    }

    public void setIsi(String isi) {
        this.isi = isi;
    }

    public void simpanKeFile(File file) {
        try {
            FileOutputStream fos = new FileOutputStream(file);
            String data = this.getIsi();
            fos.write(data.getBytes());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Dokumen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Dokumen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void bacaDariFile(File file) {
        int dataInt;
        FileInputStream fis = null;
        String hasil = "";
        try {
            fis = new FileInputStream(file);
            while ((dataInt = fis.read()) != -1) {
                hasil = hasil + (char) dataInt;
            }
            this.setIsi(hasil);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Dokumen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Dokumen.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public int hitungJumlahKata() {
        return getIsi().split(" ").length;
//        int jumlahKata = 0;
//        int i = 0;
//        while (i < getIsi().length()) {
//            // abaikan spasi pada awal string dan spasi lebih dari satu
//            while (i < getIsi().length() && getIsi().charAt(i) == ' ') {
//                i++;
//            }
//
//            if (i < getIsi().length() && getIsi().charAt(i) != ' ') {
//                jumlahKata++;
//                while (i < getIsi().length() && getIsi().charAt(i) != ' ') {
//                    i++;
//                }
//            }
//        }
//        return jumlahKata;
    }
}

