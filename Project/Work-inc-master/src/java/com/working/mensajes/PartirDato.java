package com.working.mensajes;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Hp
 */
public class PartirDato {
    public String[] textBina(String data){
        int leng = data.length();
        if((leng%8)!=0)
        {
            while((leng%8)!=0)
            {
                data=data+" ";
                leng=data.length();
            }
        }
        int leng2=(leng/8);
        String[] numeroPa = new String[leng2];
        for(int j=0;j<leng2;j++){
            String resul="";
            for(int i=0;i<8;i++){
                int as = data.charAt((8*j)+i);
                String s;    
                s = Integer.toBinaryString(as);
                int ban=8-s.length();
                for(int k=0;k<ban;k++){
                    s="0"+s;
                }
                resul+=s;
            }  
            numeroPa[j]=resul;
        }    
        return numeroPa;
    }
    public String BintoString(String[] data)
    {
        
        int[][] d = new int[data.length][8];
        char[][] c = new char[data.length][8];
        String r="";
        for(int i=0;i<data.length;i++)
        {
            for(int j=0;j<8;j++)
            {
                for(int k=0;k<8;k++)
                {
                    char xxx=data[i].charAt((8*j)+k);
                    int g=Character.getNumericValue(xxx);
                    if(g==1)
                    {
                        d[i][j]+=(int)Math.pow(2,(8-1-k));
                    }
                }
                
                c[i][j]=(char)(d[i][j]);
                r+=c[i][j];
                
            }   
            
        }
        
        return r;
    }
    
}
