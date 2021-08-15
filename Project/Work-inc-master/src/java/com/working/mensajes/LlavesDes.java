package com.working.mensajes;



public class LlavesDes {
    public String Dato_a_cifrar;
    public String Dato_Hexa;
    
    /////EL HIDDO 26/11/2018 12:28
    public String[] llavesDes(String Dato_a_cifrar) {
        
             
        char permutacion[] = {57, 49, 41, 33, 25, 17, 9, 1,
             58, 50, 42, 34, 26, 18, 10, 2,
             59, 51, 43, 35, 27, 19, 11, 3,
             60, 52, 44, 36, 63, 55, 47, 39,
             31, 23, 15, 7, 62, 54, 46, 38,
             30, 22, 14, 6, 61, 53, 45, 37,
             29, 21, 13, 5, 28, 20, 12, 4};
        /// en el primer recorrido es cero por eso el 57 hace salto de linea
        //System.out.println("");
        char mete = 0;
        /// se les resta uno porque i empieza desde el 0 por lo que llega al 55
        for (int i = 0; i < permutacion.length; i++) {            
            mete = Dato_a_cifrar.charAt(permutacion[i] - 1);
            permutacion[i] = mete;
        }        
        /*
        System.out.println("Primera caja de permutacion PC-1");        
        int cuantos = 0;
        for (int i = 0; i < permutacion.length; i++) {
            cuantos = i;            
            System.out.print(permutacion[i] + "\t");
            if (cuantos % 8 == 0 && cuantos > 0) {
                System.out.println("");                
            }
        }
        System.out.println("");*/
        String C0 = null;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 28; i++) {
            sb.append(permutacion[i]);
            C0=sb.toString();            
        }
        String D0 = null;
        StringBuilder sp = new StringBuilder();
        for (int i = 28; i < 56; i++) {
            
            sp.append(permutacion[i]);
            D0=sp.toString();                 
        }
        /*
        System.out.println("La mitas C0 es :");
        System.out.println(C0);
        System.out.println("La mitad D0 es :");
        System.out.println(D0);
        System.out.println("");
        */
        int posiciones[] = {1,1,2,2,2,2,2,2,1,2,2,2,2,2,2,1};
        String recorrido[] = new String[16];
        String C1 = null;
        for (int i = 0; i < posiciones.length; i++) {
            String cadena = C0.substring(1,28);
            char r0 = C0.charAt(0);
            StringBuilder cambio = new StringBuilder();
            cambio.append(r0);
            String cadena2 = cambio.toString();
            C1 = cadena + cadena2;
            if(posiciones[i] == 2){
                    String cadena3 = C1.substring(1,28);
                    StringBuilder cambio2 = new StringBuilder();
                    r0 = C1.charAt(0);                    
                    cambio2.append(r0);
                    String cadena4 = cambio2.toString();
                    String C2 = cadena3 + cadena4; 
                    C1 = C2;                   
                }
            recorrido[i] = C1;
            C0 = C1;   
            //System.out.println(recorrido[i]);
        }
        String recorridoD0[] = new String[16];
        String D1 = null;
        for (int i = 0; i < posiciones.length; i++) {
            String cadena5 = D0.substring(1,28);
            char r0 = D0.charAt(0);
            StringBuilder cambio3 = new StringBuilder();
            cambio3.append(r0);
            String cadena6 = cambio3.toString();
            D1 = cadena5 + cadena6;
            if(posiciones[i] == 2){
                    String cadena7 = D1.substring(1,28);
                    StringBuilder cambio4 = new StringBuilder();
                    r0 = D1.charAt(0);                    
                    cambio4.append(r0);
                    String cadena8 = cambio4.toString();
                    String D2 = cadena7 + cadena8;                    
                    
                    D1 = D2;                   
                }
            recorridoD0[i] = D1;
            D0 = D1;     
                
            //System.out.println(recorridoD0[i]);
        }
        String llaves[] = new String[16];
        char mete2 = 0;
        String CD;
        String C16D16[] = new String[16];
        for (int i = 0; i < 16; i++){            
            CD = recorrido[i] + recorridoD0[i];
            C16D16[i] = CD; 
            //System.out.println(C16D16[i]);
        }
        //System.out.println("");
        //System.out.println("");
        String k = null;               
        
        for (int i = 0; i < 16; i++) {
            StringBuilder com = new StringBuilder(); 
            char permutacion2[] = {14, 17, 11, 24, 1, 5, 3, 28,
                                15, 6, 21, 10, 23, 19, 12, 4,
                                26, 8, 16, 7, 27, 20, 13, 2,
                                41, 52, 31, 37, 47, 55, 30, 40,
                                51, 45, 33, 48, 44, 49, 39, 56,
                                34, 53, 46, 42, 50, 36, 29, 32};
               for (int j = 0; j < permutacion2.length; j++) {
                mete2 = C16D16[i].charAt(permutacion2[j]-1);
                   //System.out.print(mete2);
                   permutacion2[j] = mete2;
                   com.append(permutacion2[j]);
                   k = com.toString();
               }
               llaves[i] = k;
               k="";                
        }
        
        
            
            return llaves;
        
}
       
        public String cifrado(String dato , String Dato_a_cifrar){
            this.Dato_Hexa = dato;
        char permutacionIP[] = {
             58, 50, 42, 34, 26, 18, 10, 2,
             60, 52, 44, 36, 28, 20, 12, 4,
             62, 54, 46, 38, 30, 22, 14, 6,
             64, 56, 48, 40, 32, 24, 16, 8,
             57, 49, 41, 33, 25, 17, 9 , 1,
             59, 51, 43, 35, 27, 19, 11, 3,
             61, 53, 45, 37, 29, 21, 13, 5,
             63, 55, 47, 39, 31, 23, 15, 7
        };
        char mete3 = 0;
        for (int i = 0; i < permutacionIP.length; i++) {            
            mete3 = Dato_Hexa.charAt(permutacionIP[i] - 1);
            permutacionIP[i] = mete3;
        }
        String L0 = null;
        String R0 = null;
        StringBuilder sbu = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            sbu.append(permutacionIP[i]);
            L0=sbu.toString();            
        }
        
        StringBuilder spu = new StringBuilder();
        for (int i = 32; i < 64; i++) {            
            spu.append(permutacionIP[i]);
            R0=spu.toString();                 
        }
        
        //System.out.println("L0 es : " + L0);
        //System.out.println("R0 es : " + R0);
        
        //System.out.println("");
        for (int z = 0; z < 16; z++) {
        /*    
        System.out.println("");
        System.out.println("hacer esta madre : " + (z+1));
        System.out.println("R" + (z+1));
            System.out.println(R0);
            System.out.println("L" + (z+1));
            System.out.println(L0);
        System.out.println("La llave:");
        System.out.println((z+1) + "   "+ llaves[z]);   
        */            
        char expansion[] = {
                32, 1 , 2 , 3 , 4 , 5 , 4 , 5,
                6 , 7 , 8 , 9 , 8 , 9 , 10, 11,
                12, 13, 12, 13, 14, 15, 16, 17,
                16, 17, 18, 19, 20, 21, 20, 21,
                22, 23, 24, 25, 24, 25, 26, 27,
                28, 29, 28, 29, 30, 31, 32,  1            
            };

            char mete4 = 0;
            //System.out.println("");
            //System.out.println("Expasion:");
            for (int i = 0; i < expansion.length; i++) {            
                mete4 = R0.charAt(expansion[i] - 1);
                expansion[i] = mete4;
                
            }
            
            //System.out.println("XOR:");
            LlavesDes lla = new LlavesDes();
            String[] llav = lla.llavesDes(Dato_a_cifrar);
            int xor[] = new int[48];
                
                for (int j = 0; j < 48; j++) {
                    if(expansion[j] == llav[z].charAt(j)){
                        xor[j] = 0;
                    }
                    else{
                        xor[j] = 1;
                    }                   
                }
                String fi[] = new String[8];
                String co[] = new String[8];
                int numeros[] = {0,1,2,3};
                int numerosC[] = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
                String fila[] = {"00","01","10","11"};
                String colum[] = {"0000","0001","0010","0011","0100","0101","0110",
                "0111","1000","1001","1010","1011","1100","1101","1110","1111"};
                int filaS[] = new int[8];
                int columaS[] = new int[8];

            String Co1 = null,Co2 = null,Co3 = null,Co4 = null,Co5 = null,Co6=null,Co7=null,Co8 = null;
            String Fi1=null,Fi2=null,Fi3=null,Fi4=null,Fi5=null,Fi6=null,Fi7=null,Fi8= null;      
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            StringBuilder sb3 = new StringBuilder();
            StringBuilder sb4 = new StringBuilder();
            StringBuilder sb5 = new StringBuilder();
            StringBuilder sb6 = new StringBuilder();
            StringBuilder sb7 = new StringBuilder();
            StringBuilder sb8 = new StringBuilder();
            StringBuilder sb9 = new StringBuilder();
            StringBuilder sb10 = new StringBuilder();
            StringBuilder sb11 = new StringBuilder();
            StringBuilder sb12 = new StringBuilder();
            StringBuilder sb13 = new StringBuilder();
            StringBuilder sb14 = new StringBuilder();
            StringBuilder sb15 = new StringBuilder();
            StringBuilder sb16 = new StringBuilder();
            for (int i = 0; i < 48; i++) {
                if(i==0){
                    sb9.append(xor[i]);
                    Fi1 = sb9.toString();               
                }
                if(i==5){
                    sb9.append(xor[i]);
                    Fi1 = sb9.toString();
                    fi[0]= Fi1;
                }
                if(i==6){
                    sb10.append(xor[i]);
                    Fi2 = sb10.toString();
                }
                if(i==11){
                   sb10.append(xor[i]);
                    Fi2 = sb10.toString(); 
                    fi[1]= Fi2;
                }
                if(i==12){
                    sb11.append(xor[i]);
                    Fi3 =sb11.toString();
                }  
                if(i==17){
                    sb11.append(xor[i]);
                    Fi3 =sb11.toString();
                    fi[2]= Fi3;
                }
                if(i==18){
                    sb12.append(xor[i]);
                    Fi4 =sb12.toString();                
                }
                if (i==23) {
                    sb12.append(xor[i]);
                    Fi4 =sb12.toString();
                    fi[3]= Fi4;
                }
                if (i==24) {
                    sb13.append(xor[i]);
                    Fi5 =sb13.toString();
                }
                if (i==29) {
                    sb13.append(xor[i]);
                    Fi5 =sb13.toString();
                    fi[4]= Fi5;
                }
                if (i==30) {
                    sb14.append(xor[i]);
                    Fi6 =sb14.toString();
                }
                if(i==35){
                    sb14.append(xor[i]);
                    Fi6 =sb14.toString();
                    fi[5]= Fi6;
                }
                if(i==36){
                    sb15.append(xor[i]);
                    Fi7 =sb15.toString();
                }
                if (i==41) {
                    sb15.append(xor[i]);
                    Fi7 =sb15.toString();
                    fi[6]= Fi7;
                }
                if (i==42) {
                    sb16.append(xor[i]);
                    Fi8 =sb16.toString();
                }
                if (i==47) {
                    sb16.append(xor[i]);
                    Fi8 =sb16.toString();
                    fi[7]= Fi8;
                }
                if(i >= 1 && i < 5){ 
                    sb1.append(xor[i]);
                    Co1 =sb1.toString();
                    co[0] = Co1;
                }
                if(i>=7 && i<11){
                    sb2.append(xor[i]);
                    Co2 =sb2.toString();               
                    co[1] = Co2;
                }
                if(i>=13 && i<17){
                    sb3.append(xor[i]);
                    Co3 =sb3.toString();              
                    co[2] = Co3;
                }
                if(i>=19 && i<23){
                    sb4.append(xor[i]);
                    Co4 =sb4.toString();   
                    co[3] = Co4;
                }
                if(i>= 25&& i<29){
                    sb5.append(xor[i]);
                    Co5 =sb5.toString();              
                    co[4] = Co5;
                }
                if(i>=31 && i<35){
                    sb6.append(xor[i]);
                    Co6 =sb6.toString();     
                    co[5] = Co6;
                }
                if(i>=37 && i<41){
                    sb7.append(xor[i]);
                    Co7 =sb7.toString();     
                    co[6] = Co7;
                }
                if(i>=43 && i<47){
                    sb8.append(xor[i]);
                    Co8 =sb8.toString(); 
                    co[7] = Co8;
                }                    
            }           
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 4; j++) {
                    if(fi[i].equals(fila[j])){
                        filaS[i] = numeros[j];
                    } 
                }
            }

            /*System.out.println("");
            System.out.println("filaS");
            for(int i = 0; i < 8; i++) {
                System.out.println(filaS[i]); 
            }*/
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 16; j++) {
                    if(co[i].equals(colum[j])){
                        columaS[i]= numerosC[j];
                    } 
                }
            } 
            /*System.out.println("");
            System.out.println("ColumS");
            for(int i = 0; i < 8; i++) {
                System.out.println(columaS[i]); 
            }*/

            int S1C [][] = {
                    {14 ,4 ,13, 1, 2, 15, 11, 8, 3, 10, 6, 12, 5, 9 ,0 ,7},
                    {0, 15, 7, 4, 14, 2, 13, 1, 10, 6, 12, 11, 9, 5, 3, 8},
                    { 4, 1, 14, 8, 13, 6, 2, 11, 15, 12, 9, 7, 3, 10, 5, 0},
                    {15, 12, 8, 2, 4, 9, 1, 7, 5, 11, 3, 14, 10, 0, 6, 13}
            };
            char S2C [][] = {
                {15 ,1 ,8 ,14 ,6 ,11 ,3 ,4 ,9 ,7 ,2 ,13, 12 ,0, 5 ,10},
                {3 ,13 ,4 ,7 ,15 ,2 ,8 ,14 ,12 ,0 ,1 ,10 ,6 ,9 ,11 ,5},
                {0 ,14, 7, 11 ,10 ,4, 13, 1 ,5 ,8 ,12, 6, 9 ,3 ,2 ,15 },
                {13 ,8 ,10 ,1 ,3 ,15, 4, 2 ,11, 6, 7 ,12 ,0 ,5 ,14, 9  }
            };
            char S3C [][] = {
                { 10 ,0 ,9 ,14 ,6 ,3 ,15, 5, 1 ,13 ,12, 7, 11, 4, 2, 8},
                { 13 ,7 ,0 ,9,3, 4 ,6 ,10, 2, 8, 5, 14, 12, 11, 15, 1},
                { 13, 6 ,4 ,9 ,8, 15, 3 ,0, 11, 1, 2, 12 ,5, 10, 14 ,7},
                {1 ,10, 13 ,0 ,6, 9, 8, 7, 4 ,15 ,14 ,3 ,11, 5, 2, 12  }
            };
            char S4C [][] = {
                { 7 ,13, 14, 3, 0, 6, 9 ,10, 1, 2, 8, 5, 11 ,12 ,4 ,15},
                { 13 ,8 ,11, 5 ,6 ,15, 0, 3, 4, 7, 2, 12, 1, 10, 14, 9},
                { 10, 6, 9, 0, 12, 11, 7, 13, 15, 1, 3, 14, 5, 2, 8, 4 },
                {3 ,15, 0, 6, 10, 1, 13, 8, 9, 4, 5, 11, 12, 7, 2, 14  }
            };
            char S5C [][] = {
                { 2, 12, 4, 1, 7, 10, 11, 6, 8, 5, 3 ,15, 13, 0 ,14, 9},
                { 14 ,11, 2 ,12, 4, 7, 13, 1, 5, 0, 15, 10, 3, 9, 8, 6},
                { 4 ,2, 1, 11, 10, 13, 7, 8, 15, 9 ,12 ,5 ,6, 3, 0, 14 },
                {11 ,8 ,12, 7, 1 ,14, 2, 13 ,6 ,15 ,0 ,9 ,10, 4, 5,3 }
            };
            char S6C [][] = {
                { 12 ,1 ,10 ,15 ,9 ,2 ,6 ,8 ,0 ,13 , 3, 4 ,14 ,7 ,5 ,11},
                { 10, 15, 4, 2, 7, 12, 9 ,5 ,6 ,1 ,13 ,14, 0 ,11, 3 ,8},
                { 9 ,14 ,15, 5, 2, 8 ,12, 3, 7, 0, 4, 10, 1, 13, 11, 6},
                {4 ,3 ,2 ,12, 9, 5, 15, 10, 11, 14, 1, 7, 6, 0, 8, 13}
            };
            char S7C [][] = {
                {  4 ,11 ,2 ,14, 15, 0 ,8 ,13 ,3 ,12, 9, 7, 5, 10, 6 ,1},
                { 13 ,0 ,11, 7 ,4 ,9 ,1 ,10, 14, 3, 5, 12, 2 ,15, 8, 6},
                { 1 ,4 ,11, 13, 12, 3 ,7 ,14, 10, 15, 6 ,8 ,0 ,5 ,9 ,2},
                { 6 ,11, 13, 8, 1, 4, 10 ,7 ,9 ,5 ,0, 15, 14, 2, 3, 12}
            };
            char S8C [][] = {
                {  13, 2 ,8 ,4 ,6 ,15, 11, 1, 10, 9 ,3 ,14, 5, 0, 12, 7},
                {  1, 15, 13 ,8 ,10, 3, 7, 4 ,12 ,5 ,6 ,11, 0, 14, 9, 2},
                { 7, 11, 4 ,1 ,9 ,12 ,14, 2, 0 ,6 ,10, 13 ,15 ,3 ,5 ,8},
                { 2 ,1 ,14, 7, 4, 10, 8, 13, 15, 12, 9, 0, 3, 5, 6, 11}
            };
            int S[] = new int[8];       
                S[0] = S1C[filaS[0]][columaS[0]];
                S[1] = S2C[filaS[1]][columaS[1]];
                S[2] = S3C[filaS[2]][columaS[2]];
                S[3] = S4C[filaS[3]][columaS[3]];
                S[4] = S5C[filaS[4]][columaS[4]];
                S[5] = S6C[filaS[5]][columaS[5]];
                S[6] = S7C[filaS[6]][columaS[6]];
                S[7] = S8C[filaS[7]][columaS[7]];

            StringBuilder sb17 = new StringBuilder();   
            String cajaS = null;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 16; j++) {
                    if(S[i] == numerosC[j]){
                       sb17.append(colum[j]);
                       cajaS = sb17.toString();
                    }
                }
            } 
            /*
            System.out.println("");
            System.out.println("binario a decimal caja");
            System.out.println(cajaS);
            */
            char permutacionP[] ={
                16,7,20,21, 29, 12, 28, 17,
                1, 15, 23, 26, 5 ,18 ,31 ,10,
                2, 8, 24, 14, 32, 27, 3, 9,
                19, 13, 30, 6 ,22, 11, 4, 25
            };
            //System.out.println("PermutacionP :");
            char met = 0;
            for (int i = 0; i < permutacionP.length; i++){            
                met = cajaS.charAt(permutacionP[i] - 1);
                permutacionP[i] = met;
                //System.out.print(permutacionP[i]);
            }     
            //System.out.println("");
            //System.out.println("XORP:");     
            int xorP[] = new int[32];   
                
                for (int j = 0; j < 32; j++) {
                    if(permutacionP[j] == L0.charAt(j)){
                        xorP[j] = 0;
                    }
                    else{
                        xorP[j] = 1;
                    }
                    //System.out.print(xorP[j]);
                }
            StringBuilder sb18 = new StringBuilder();  
            String R1 = null;            
            for (int i = 0; i < xorP.length; i++) {
                sb18.append(xorP[i]);
                R1=sb18.toString();            
            }
            /*
            System.out.println("");
            System.out.println("R1:");
            System.out.println(R1);*/
            L0 = R0;
            R0 = R1;
            /*
            System.out.println("R" + (z+1));
            System.out.println(R0);
            System.out.println("L" + (z+1));
            System.out.println(L0);*/        
        }
        
        //System.out.println("");
        String fin = R0 + L0;
        //System.out.println(fin);
        //System.out.println("");
        char permutacionfinal []={
        40, 8, 48, 16 ,56 ,24 ,64 ,32,
        39,7, 47, 15, 55, 23, 63, 31,
        38, 6, 46, 14, 54, 22, 62, 30,
        37,5 ,45 ,13 ,53 ,21, 61, 29,
        36,4, 44, 12, 52, 20, 60, 28,
        35, 3, 43, 11 ,51 ,19, 59, 27,
        34 ,2 ,42 ,10 ,50, 18, 58, 26,
        33 ,1 ,41, 9, 49, 17, 57, 25
        };
        char me = 0;
        
        for (int i = 0; i < permutacionfinal.length; i++) {            
            me = fin.charAt(permutacionfinal[i] - 1);
            permutacionfinal[i] = me;
        }        
        String fina = null;
        StringBuilder FIN = new StringBuilder();
        for (int i = 0; i < 64; i++) {
            FIN.append(permutacionfinal[i]);
            fina=FIN.toString();            
        }
         
        return fina;
        }
        public String descifrado(String dato, String Dato_a_cifrar){
            this.Dato_Hexa = dato;
        char permutacionIP[] = {
             58, 50, 42, 34, 26, 18, 10, 2,
             60, 52, 44, 36, 28, 20, 12, 4,
             62, 54, 46, 38, 30, 22, 14, 6,
             64, 56, 48, 40, 32, 24, 16, 8,
             57, 49, 41, 33, 25, 17, 9 , 1,
             59, 51, 43, 35, 27, 19, 11, 3,
             61, 53, 45, 37, 29, 21, 13, 5,
             63, 55, 47, 39, 31, 23, 15, 7
        };
        char mete3 = 0;
        for (int i = 0; i < permutacionIP.length; i++) {            
            mete3 = Dato_Hexa.charAt(permutacionIP[i] - 1);
            permutacionIP[i] = mete3;
        }
        String L0 = null;
        String R0 = null;
        StringBuilder sbu = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            sbu.append(permutacionIP[i]);
            L0=sbu.toString();            
        }
        
        StringBuilder spu = new StringBuilder();
        for (int i = 32; i < 64; i++) {            
            spu.append(permutacionIP[i]);
            R0=spu.toString();                 
        }
        
        //System.out.println("L0 es : " + L0);
        //System.out.println("R0 es : " + R0);
        
        //System.out.println("");
        for (int z = 15; z >= 0; z--) {
        /*    
        System.out.println("");
        System.out.println("hacer esta madre : " + (z+1));
        System.out.println("R" + (z+1));
            System.out.println(R0);
            System.out.println("L" + (z+1));
            System.out.println(L0);
        System.out.println("La llave:");
        System.out.println((z+1) + "   "+ llaves[z]);   
        */            
        char expansion[] = {
                32, 1 , 2 , 3 , 4 , 5 , 4 , 5,
                6 , 7 , 8 , 9 , 8 , 9 , 10, 11,
                12, 13, 12, 13, 14, 15, 16, 17,
                16, 17, 18, 19, 20, 21, 20, 21,
                22, 23, 24, 25, 24, 25, 26, 27,
                28, 29, 28, 29, 30, 31, 32,  1            
            };

            char mete4 = 0;
            //System.out.println("");
            //System.out.println("Expasion:");
            for (int i = 0; i < expansion.length; i++) {            
                mete4 = R0.charAt(expansion[i] - 1);
                expansion[i] = mete4;
                
            }
            //System.out.println("XOR:");
            LlavesDes lla = new LlavesDes();
            String[] llav = lla.llavesDes(Dato_a_cifrar);
            int xor[] = new int[48];
                
                for (int j = 0; j < 48; j++) {
                    if(expansion[j] == llav[z].charAt(j)){
                        xor[j] = 0;
                    }
                    else{
                        xor[j] = 1;
                    }                   
                }
                String fi[] = new String[8];
                String co[] = new String[8];
                int numeros[] = {0,1,2,3};
                int numerosC[] = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
                String fila[] = {"00","01","10","11"};
                String colum[] = {"0000","0001","0010","0011","0100","0101","0110",
                "0111","1000","1001","1010","1011","1100","1101","1110","1111"};
                int filaS[] = new int[8];
                int columaS[] = new int[8];

            String Co1 = null,Co2 = null,Co3 = null,Co4 = null,Co5 = null,Co6=null,Co7=null,Co8 = null;
            String Fi1=null,Fi2=null,Fi3=null,Fi4=null,Fi5=null,Fi6=null,Fi7=null,Fi8= null;      
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            StringBuilder sb3 = new StringBuilder();
            StringBuilder sb4 = new StringBuilder();
            StringBuilder sb5 = new StringBuilder();
            StringBuilder sb6 = new StringBuilder();
            StringBuilder sb7 = new StringBuilder();
            StringBuilder sb8 = new StringBuilder();
            StringBuilder sb9 = new StringBuilder();
            StringBuilder sb10 = new StringBuilder();
            StringBuilder sb11 = new StringBuilder();
            StringBuilder sb12 = new StringBuilder();
            StringBuilder sb13 = new StringBuilder();
            StringBuilder sb14 = new StringBuilder();
            StringBuilder sb15 = new StringBuilder();
            StringBuilder sb16 = new StringBuilder();
            for (int i = 0; i < 48; i++) {
                if(i==0){
                    sb9.append(xor[i]);
                    Fi1 = sb9.toString();               
                }
                if(i==5){
                    sb9.append(xor[i]);
                    Fi1 = sb9.toString();
                    fi[0]= Fi1;
                }
                if(i==6){
                    sb10.append(xor[i]);
                    Fi2 = sb10.toString();
                }
                if(i==11){
                   sb10.append(xor[i]);
                    Fi2 = sb10.toString(); 
                    fi[1]= Fi2;
                }
                if(i==12){
                    sb11.append(xor[i]);
                    Fi3 =sb11.toString();
                }  
                if(i==17){
                    sb11.append(xor[i]);
                    Fi3 =sb11.toString();
                    fi[2]= Fi3;
                }
                if(i==18){
                    sb12.append(xor[i]);
                    Fi4 =sb12.toString();                
                }
                if (i==23) {
                    sb12.append(xor[i]);
                    Fi4 =sb12.toString();
                    fi[3]= Fi4;
                }
                if (i==24) {
                    sb13.append(xor[i]);
                    Fi5 =sb13.toString();
                }
                if (i==29) {
                    sb13.append(xor[i]);
                    Fi5 =sb13.toString();
                    fi[4]= Fi5;
                }
                if (i==30) {
                    sb14.append(xor[i]);
                    Fi6 =sb14.toString();
                }
                if(i==35){
                    sb14.append(xor[i]);
                    Fi6 =sb14.toString();
                    fi[5]= Fi6;
                }
                if(i==36){
                    sb15.append(xor[i]);
                    Fi7 =sb15.toString();
                }
                if (i==41) {
                    sb15.append(xor[i]);
                    Fi7 =sb15.toString();
                    fi[6]= Fi7;
                }
                if (i==42) {
                    sb16.append(xor[i]);
                    Fi8 =sb16.toString();
                }
                if (i==47) {
                    sb16.append(xor[i]);
                    Fi8 =sb16.toString();
                    fi[7]= Fi8;
                }
                if(i >= 1 && i < 5){ 
                    sb1.append(xor[i]);
                    Co1 =sb1.toString();
                    co[0] = Co1;
                }
                if(i>=7 && i<11){
                    sb2.append(xor[i]);
                    Co2 =sb2.toString();               
                    co[1] = Co2;
                }
                if(i>=13 && i<17){
                    sb3.append(xor[i]);
                    Co3 =sb3.toString();              
                    co[2] = Co3;
                }
                if(i>=19 && i<23){
                    sb4.append(xor[i]);
                    Co4 =sb4.toString();   
                    co[3] = Co4;
                }
                if(i>= 25&& i<29){
                    sb5.append(xor[i]);
                    Co5 =sb5.toString();              
                    co[4] = Co5;
                }
                if(i>=31 && i<35){
                    sb6.append(xor[i]);
                    Co6 =sb6.toString();     
                    co[5] = Co6;
                }
                if(i>=37 && i<41){
                    sb7.append(xor[i]);
                    Co7 =sb7.toString();     
                    co[6] = Co7;
                }
                if(i>=43 && i<47){
                    sb8.append(xor[i]);
                    Co8 =sb8.toString(); 
                    co[7] = Co8;
                }                    
            }           
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 4; j++) {
                    if(fi[i].equals(fila[j])){
                        filaS[i] = numeros[j];
                    } 
                }
            }

            /*System.out.println("");
            System.out.println("filaS");
            for(int i = 0; i < 8; i++) {
                System.out.println(filaS[i]); 
            }*/
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 16; j++) {
                    if(co[i].equals(colum[j])){
                        columaS[i]= numerosC[j];
                    } 
                }
            } 
            /*System.out.println("");
            System.out.println("ColumS");
            for(int i = 0; i < 8; i++) {
                System.out.println(columaS[i]); 
            }*/

            int S1C [][] = {
                    {14 ,4 ,13, 1, 2, 15, 11, 8, 3, 10, 6, 12, 5, 9 ,0 ,7},
                    {0, 15, 7, 4, 14, 2, 13, 1, 10, 6, 12, 11, 9, 5, 3, 8},
                    { 4, 1, 14, 8, 13, 6, 2, 11, 15, 12, 9, 7, 3, 10, 5, 0},
                    {15, 12, 8, 2, 4, 9, 1, 7, 5, 11, 3, 14, 10, 0, 6, 13}
            };
            char S2C [][] = {
                {15 ,1 ,8 ,14 ,6 ,11 ,3 ,4 ,9 ,7 ,2 ,13, 12 ,0, 5 ,10},
                {3 ,13 ,4 ,7 ,15 ,2 ,8 ,14 ,12 ,0 ,1 ,10 ,6 ,9 ,11 ,5},
                {0 ,14, 7, 11 ,10 ,4, 13, 1 ,5 ,8 ,12, 6, 9 ,3 ,2 ,15 },
                {13 ,8 ,10 ,1 ,3 ,15, 4, 2 ,11, 6, 7 ,12 ,0 ,5 ,14, 9  }
            };
            char S3C [][] = {
                { 10 ,0 ,9 ,14 ,6 ,3 ,15, 5, 1 ,13 ,12, 7, 11, 4, 2, 8},
                { 13 ,7 ,0 ,9,3, 4 ,6 ,10, 2, 8, 5, 14, 12, 11, 15, 1},
                { 13, 6 ,4 ,9 ,8, 15, 3 ,0, 11, 1, 2, 12 ,5, 10, 14 ,7},
                {1 ,10, 13 ,0 ,6, 9, 8, 7, 4 ,15 ,14 ,3 ,11, 5, 2, 12  }
            };
            char S4C [][] = {
                { 7 ,13, 14, 3, 0, 6, 9 ,10, 1, 2, 8, 5, 11 ,12 ,4 ,15},
                { 13 ,8 ,11, 5 ,6 ,15, 0, 3, 4, 7, 2, 12, 1, 10, 14, 9},
                { 10, 6, 9, 0, 12, 11, 7, 13, 15, 1, 3, 14, 5, 2, 8, 4 },
                {3 ,15, 0, 6, 10, 1, 13, 8, 9, 4, 5, 11, 12, 7, 2, 14  }
            };
            char S5C [][] = {
                { 2, 12, 4, 1, 7, 10, 11, 6, 8, 5, 3 ,15, 13, 0 ,14, 9},
                { 14 ,11, 2 ,12, 4, 7, 13, 1, 5, 0, 15, 10, 3, 9, 8, 6},
                { 4 ,2, 1, 11, 10, 13, 7, 8, 15, 9 ,12 ,5 ,6, 3, 0, 14 },
                {11 ,8 ,12, 7, 1 ,14, 2, 13 ,6 ,15 ,0 ,9 ,10, 4, 5,3 }
            };
            char S6C [][] = {
                { 12 ,1 ,10 ,15 ,9 ,2 ,6 ,8 ,0 ,13 , 3, 4 ,14 ,7 ,5 ,11},
                { 10, 15, 4, 2, 7, 12, 9 ,5 ,6 ,1 ,13 ,14, 0 ,11, 3 ,8},
                { 9 ,14 ,15, 5, 2, 8 ,12, 3, 7, 0, 4, 10, 1, 13, 11, 6},
                {4 ,3 ,2 ,12, 9, 5, 15, 10, 11, 14, 1, 7, 6, 0, 8, 13}
            };
            char S7C [][] = {
                {  4 ,11 ,2 ,14, 15, 0 ,8 ,13 ,3 ,12, 9, 7, 5, 10, 6 ,1},
                { 13 ,0 ,11, 7 ,4 ,9 ,1 ,10, 14, 3, 5, 12, 2 ,15, 8, 6},
                { 1 ,4 ,11, 13, 12, 3 ,7 ,14, 10, 15, 6 ,8 ,0 ,5 ,9 ,2},
                { 6 ,11, 13, 8, 1, 4, 10 ,7 ,9 ,5 ,0, 15, 14, 2, 3, 12}
            };
            char S8C [][] = {
                {  13, 2 ,8 ,4 ,6 ,15, 11, 1, 10, 9 ,3 ,14, 5, 0, 12, 7},
                {  1, 15, 13 ,8 ,10, 3, 7, 4 ,12 ,5 ,6 ,11, 0, 14, 9, 2},
                { 7, 11, 4 ,1 ,9 ,12 ,14, 2, 0 ,6 ,10, 13 ,15 ,3 ,5 ,8},
                { 2 ,1 ,14, 7, 4, 10, 8, 13, 15, 12, 9, 0, 3, 5, 6, 11}
            };
            int S[] = new int[8];       
                S[0] = S1C[filaS[0]][columaS[0]];
                S[1] = S2C[filaS[1]][columaS[1]];
                S[2] = S3C[filaS[2]][columaS[2]];
                S[3] = S4C[filaS[3]][columaS[3]];
                S[4] = S5C[filaS[4]][columaS[4]];
                S[5] = S6C[filaS[5]][columaS[5]];
                S[6] = S7C[filaS[6]][columaS[6]];
                S[7] = S8C[filaS[7]][columaS[7]];

            StringBuilder sb17 = new StringBuilder();   
            String cajaS = null;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 16; j++) {
                    if(S[i] == numerosC[j]){
                       sb17.append(colum[j]);
                       cajaS = sb17.toString();
                    }
                }
            } 
            /*
            System.out.println("");
            System.out.println("binario a decimal caja");
            System.out.println(cajaS);
            */
            char permutacionP[] ={
                16,7,20,21, 29, 12, 28, 17,
                1, 15, 23, 26, 5 ,18 ,31 ,10,
                2, 8, 24, 14, 32, 27, 3, 9,
                19, 13, 30, 6 ,22, 11, 4, 25
            };
            //System.out.println("PermutacionP :");
            char met = 0;
            for (int i = 0; i < permutacionP.length; i++){            
                met = cajaS.charAt(permutacionP[i] - 1);
                permutacionP[i] = met;
                //System.out.print(permutacionP[i]);
            }     
            //System.out.println("");
            //System.out.println("XORP:");     
            int xorP[] = new int[32];   
                
                for (int j = 0; j < 32; j++) {
                    if(permutacionP[j] == L0.charAt(j)){
                        xorP[j] = 0;
                    }
                    else{
                        xorP[j] = 1;
                    }
                    //System.out.print(xorP[j]);
                }
            StringBuilder sb18 = new StringBuilder();  
            String R1 = null;            
            for (int i = 0; i < xorP.length; i++) {
                sb18.append(xorP[i]);
                R1=sb18.toString();            
            }
            /*
            System.out.println("");
            System.out.println("R1:");
            System.out.println(R1);*/
            L0 = R0;
            R0 = R1;
            /*
            System.out.println("R" + (z+1));
            System.out.println(R0);
            System.out.println("L" + (z+1));
            System.out.println(L0);*/        
        }
        
        //System.out.println("");
        String fin = R0 + L0;
        //System.out.println(fin);
        //System.out.println("");
        char permutacionfinal []={
        40, 8, 48, 16 ,56 ,24 ,64 ,32,
        39,7, 47, 15, 55, 23, 63, 31,
        38, 6, 46, 14, 54, 22, 62, 30,
        37,5 ,45 ,13 ,53 ,21, 61, 29,
        36,4, 44, 12, 52, 20, 60, 28,
        35, 3, 43, 11 ,51 ,19, 59, 27,
        34 ,2 ,42 ,10 ,50, 18, 58, 26,
        33 ,1 ,41, 9, 49, 17, 57, 25
        };
        char me = 0;
        
        for (int i = 0; i < permutacionfinal.length; i++) {            
            me = fin.charAt(permutacionfinal[i] - 1);
            permutacionfinal[i] = me;
        }        
        String fina = null;
        StringBuilder FIN = new StringBuilder();
        for (int i = 0; i < 64; i++) {
            FIN.append(permutacionfinal[i]);
            fina=FIN.toString();            
        }
          
        return fina;
        }
        public String Cifrado(String dato, String Dato_a_cifrar){
        LlavesDes ll = new LlavesDes();
        PartirDato par = new PartirDato();
        String[] datoD = par.textBina(dato);
        String[] datoA = par.textBina(Dato_a_cifrar);
        String[] DESC = new String[datoD.length];
        String cifra;
        for (int i = 0; i < datoD.length; i++) {
            for (int j = 0; j < datoA.length; j++) {
            DESC[i] = ll.cifrado(datoD[i],datoA[j]);    
            }
        }
        cifra = par.BintoString(DESC);
        return cifra;
        }
        public String Descifrado(String datosDa, String Dato_a_cifrar){
            LlavesDes lla = new LlavesDes();
            PartirDato par = new PartirDato();
            String[] datoDc = par.textBina(datosDa);
            String[] datoA = par.textBina(Dato_a_cifrar);
            String[] DESD = new String[datoDc.length];
            String descifra;
            for (int i = 0; i < datoDc.length; i++) {
                for (int j = 0; j < datoA.length; j++) {
                DESD[i] = lla.descifrado(datoDc[i],datoA[j]);
                }
                  
            }
            descifra = par.BintoString(DESD);
            return descifra;
        }
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
    

