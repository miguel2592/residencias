package com.Mflores.vida;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	private Button botonComienzo, botonSalir,botonSiguiente;
	Button[][] B=new Button[5][5]; 
    int[][] b= new int [5][5];
    int[] x=new int [25];
	int fila, columna,cont;
	int salir=0;
	boolean stop=false;
	String [][] boton = new String[5][5];
	
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
       
        botonComienzo = (Button)findViewById(R.id.botonInicio);
        botonComienzo.setOnClickListener(new View.OnClickListener() {        
        @Override
        public void onClick(View v) {
       	 Toast.makeText(MainActivity.this,R.string.toast_Inicio,
       			 Toast.LENGTH_LONG).show(); 	 
	       	Toast.makeText(MainActivity.this,R.string.toast_Inicio,
	      			 Toast.LENGTH_LONG).show();
        }
        });
        botonSiguiente = (Button)findViewById(R.id.botonSig);
        botonSiguiente.setOnClickListener(new View.OnClickListener() {        
        @Override
        public void onClick(View v) {
	       	cont=0;
	       	 for(fila=0;fila<5;fila++){
	       		for(columna=0;columna<5;columna++){
	       			cont++;
	       			if(B[fila][columna]==B[0][0]){
	       				x[cont-1]= b[0][1]+ b[1][1]+b[1][0];
	       				
	       			}
	       			else if(B[fila][columna]==B[0][1]|| B[fila][columna]==B[0][2] || B[fila][columna]==B[0][3])
		       			{
		       				x[cont-1]= b[0][columna-1] + b[fila+1][columna-1] + b[fila+1][columna] + b[fila+1][columna+1] + b[0][columna+1];
		       				
		       				
		       			}
		       			else if(B[fila][columna]==B[0][4]){
		       				x[cont-1]= b[0][3]+ b[1][3]+b[1][4];
		       			}
		       				else if(B[fila][columna]==B[1][0] || B[fila][columna]==B[2][0] || B[fila][columna]==B[3][0]){
		       					x[cont-1]=b[fila-1][columna]+ b[fila-1][columna+1]+b[fila][columna+1]+b[fila+1][columna+1]+b[fila+1][columna];
		       				}
			       				else if(B[fila][columna]==B[1][1] || B[fila][columna]==B[1][2] || B[fila][columna]==B[1][3]||B[fila][columna]==B[2][1]||B[fila][columna]==B[2][2] || B[fila][columna]==B[2][3] || B[fila][columna]==B[3][1] || B[fila][columna]==B[3][2] || B[fila][columna]==B[3][3] ){
			       					x[cont-1]=b[fila-1][columna-1]+b[fila-1][columna]+b[fila-1][columna+1]+b[fila][columna+1]+b[fila+1][columna+1]+b[fila+1][columna]+b[fila+1][columna-1]+b[fila][columna-1];
			       				}
				       				else if(B[fila][columna]==B[1][4] || B[fila][columna]==B[2][4] || B[fila][columna]==B[3][4]){
				       					x[cont-1]=b[fila-1][columna]+b[fila-1][columna-1]+b[fila][columna-1]+b[fila+1][columna-1]+b[fila+1][columna];
				       				}
					       				else if(B[fila][columna]==B[4][0]){
					       					x[cont-1]= b[3][0]+ b[3][1]+b[4][1];
					       				}
						       				else if(B[fila][columna]==B[4][1]|| B[fila][columna]==B[4][2] || B[fila][columna]==B[4][3])
							       			{
							       				x[cont-1]= b[fila][columna-1] + b[fila-1][columna-1] + b[fila-1][columna] + b[fila-1][columna+1] + b[fila][columna+1];
							       			}
							       				else if(B[fila][columna]==B[4][4]){
								       				x[cont-1]= b[4][3]+ b[3][3]+b[3][4];
								       			}
	       		 }
	       	 }
	       	 
	       	 cont=0;
	       	 for(fila=0;fila<5;fila++){
	        		for(columna=0;columna<5;columna++){
	        	        			
	        			if(x[cont]<2 && b[fila][columna]==1){
	        				B[fila][columna].setBackgroundColor(Color.BLUE);
	        				b[fila][columna]=0;
	        			}
	        			if(x[cont]>3 && b[fila][columna]==1){
	        				B[fila][columna].setBackgroundColor(Color.BLUE);
	        				b[fila][columna]=0;
	        			}
	        			if(x[cont]==3 && b[fila][columna]==0){
	        				B[fila][columna].setBackgroundColor(Color.GREEN);
	        				b[fila][columna]=1;
	        			}
	        			cont++;
	        		}
	       	 }   	 
        }
        
        });
       
        
        botonSalir = (Button)findViewById(R.id.botonSalir);
        botonSalir.setOnClickListener(new View.OnClickListener() {        
        @Override
	        public void onClick(View v) {
        	
        	for(fila=0;fila<5;fila++){
        		for(columna=0;columna<5;columna++){
        				B[fila][columna].setBackgroundColor(Color.BLUE);
        				b[fila][columna]=0;
        				
        		}
        	}
        }
        });
        
        B[0][0] = (Button)findViewById(R.id.boton11);
        B[0][0].setOnClickListener(new View.OnClickListener() {        
        @Override
	        public void onClick(View v) {
		        if(b[0][0]==0){
		       	 	B[0][0].setBackgroundColor(Color.GREEN);
		       	 	b[0][0]=1;
		        }
		        else if(b[0][0]==1){
		        	B[0][0].setBackgroundColor(Color.BLUE);
		        	b[0][0]=0;
		        }		 
	        }
        });
        
        B[0][1] = (Button)findViewById(R.id.boton12);
        B[0][1].setOnClickListener(new View.OnClickListener() {        
        @Override
	        public void onClick(View v) {
		        if(b[0][1]==0){
		       	 	B[0][1].setBackgroundColor(Color.GREEN);
		       	 	b[0][1]=1;
		        }
		        else if(b[0][1]==1){
		        	B[0][1].setBackgroundColor(Color.BLUE);
		        	b[0][1]=0;
		        }		 
	        }
        });
        
        B[0][2] = (Button)findViewById(R.id.boton13);
        B[0][2].setOnClickListener(new View.OnClickListener() {        
        @Override
	        public void onClick(View v) {
		        if(b[0][2]==0){
		       	 	B[0][2].setBackgroundColor(Color.GREEN);
		       	 	b[0][2]=1;
		        }
		        else if(b[0][2]==1){
		        	B[0][2].setBackgroundColor(Color.BLUE);
		        	b[0][2]=0;
		        }		 
	        }
        });
        B[0][3] = (Button)findViewById(R.id.boton14);
        B[0][3].setOnClickListener(new View.OnClickListener() {        
        @Override
	        public void onClick(View v) {
		        if(b[0][3]==0){
		       	 	B[0][3].setBackgroundColor(Color.GREEN);
		       	 	b[0][3]=1;
		        }
		        else if(b[0][3]==1){
		        	B[0][3].setBackgroundColor(Color.BLUE);
		        	b[0][3]=0;
		        }		 
	        }
        });
        
        B[0][4] = (Button)findViewById(R.id.boton15);
        B[0][4].setOnClickListener(new View.OnClickListener() {        
        @Override
	        public void onClick(View v) {
		        if(b[0][4]==0){
		       	 	B[0][4].setBackgroundColor(Color.GREEN);
		       	 	b[0][4]=1;
		        }
		        else if(b[0][4]==1){
		        	B[0][4].setBackgroundColor(Color.BLUE);
		        	b[0][4]=0;
		        }		 
	        }
        });
        
        B[1][0] = (Button)findViewById(R.id.boton21);
        B[1][0].setOnClickListener(new View.OnClickListener() {        
        @Override
	        public void onClick(View v) {
		        if(b[1][0]==0){
		       	 	B[1][0].setBackgroundColor(Color.GREEN);
		       	 	b[1][0]=1;
		        }
		        else if(b[1][0]==1){
		        	B[1][0].setBackgroundColor(Color.BLUE);
		        	b[1][0]=0;
		        }		 
	        }
        });
        
        B[1][1] = (Button)findViewById(R.id.boton22);
        B[1][1].setOnClickListener(new View.OnClickListener() {        
        @Override
	        public void onClick(View v) {
		        if(b[1][1]==0){
		       	 	B[1][1].setBackgroundColor(Color.GREEN);
		       	 	b[1][1]=1;
		        }
		        else if(b[1][1]==1){
		        	B[1][1].setBackgroundColor(Color.BLUE);
		        	b[1][1]=0;
		        }		 
	        }
        });
        
        B[1][2] = (Button)findViewById(R.id.boton23);
        B[1][2].setOnClickListener(new View.OnClickListener() {        
        @Override
	        public void onClick(View v) {
		        if(b[1][2]==0){
		       	 	B[1][2].setBackgroundColor(Color.GREEN);
		       	 	b[1][2]=1;
		        }
		        else if(b[1][2]==1){
		        	B[1][2].setBackgroundColor(Color.BLUE);
		        	b[1][2]=0;
		        }		 
	        }
        });
        
        B[1][3] = (Button)findViewById(R.id.boton24);
        B[1][3].setOnClickListener(new View.OnClickListener() {        
        @Override
	        public void onClick(View v) {
		        if(b[1][3]==0){
		       	 	B[1][3].setBackgroundColor(Color.GREEN);
		       	 	b[1][3]=1;
		        }
		        else if(b[1][3]==1){
		        	B[1][3].setBackgroundColor(Color.BLUE);
		        	b[1][3]=0;
		        }		 
	        }
        });
        B[1][4] = (Button)findViewById(R.id.boton25);
        B[1][4].setOnClickListener(new View.OnClickListener() {        
        @Override
	        public void onClick(View v) {
		        if(b[1][4]==0){
		       	 	B[1][4].setBackgroundColor(Color.GREEN);
		       	 	b[1][4]=1;
		        }
		        else if(b[1][4]==1){
		        	B[1][4].setBackgroundColor(Color.BLUE);
		        	b[1][4]=0;
		        }		 
	        }
        });
        
        B[2][0] = (Button)findViewById(R.id.boton31);
        B[2][0].setOnClickListener(new View.OnClickListener() {        
        @Override
	        public void onClick(View v) {
		        if(b[2][0]==0){
		       	 	B[2][0].setBackgroundColor(Color.GREEN);
		       	 	b[2][0]=1;
		        }
		        else if(b[2][0]==1){
		        	B[2][0].setBackgroundColor(Color.BLUE);
		        	b[2][0]=0;
		        }		 
	        }
        });
        
        B[2][1] = (Button)findViewById(R.id.boton32);
        B[2][1].setOnClickListener(new View.OnClickListener() {        
        @Override
	        public void onClick(View v) {
		        if(b[2][1]==0){
		       	 	B[2][1].setBackgroundColor(Color.GREEN);
		       	 	b[2][1]=1;
		        }
		        else if(b[2][1]==1){
		        	B[2][1].setBackgroundColor(Color.BLUE);
		        	b[2][1]=0;
		        }		 
	        }
        });
        
        B[2][2] = (Button)findViewById(R.id.boton33);
        B[2][2].setOnClickListener(new View.OnClickListener() {        
        @Override
	        public void onClick(View v) {
		        if(b[2][2]==0){
		       	 	B[2][2].setBackgroundColor(Color.GREEN);
		       	 	b[2][2]=1;
		        }
		        else if(b[2][2]==1){
		        	B[2][2].setBackgroundColor(Color.BLUE);
		        	b[2][2]=0;
		        }		 
	        }
        });
        
        B[2][3] = (Button)findViewById(R.id.boton34);
        B[2][3].setOnClickListener(new View.OnClickListener() {        
        @Override
	        public void onClick(View v) {
		        if(b[2][3]==0){
		       	 	B[2][3].setBackgroundColor(Color.GREEN);
		       	 	b[2][3]=1;
		        }
		        else if(b[2][3]==1){
		        	B[2][3].setBackgroundColor(Color.BLUE);
		        	b[2][3]=0;
		        }		 
	        }
        });
        
        B[2][4] = (Button)findViewById(R.id.boton35);
        B[2][4].setOnClickListener(new View.OnClickListener() {        
        @Override
	        public void onClick(View v) {
		        if(b[2][4]==0){
		       	 	B[2][4].setBackgroundColor(Color.GREEN);
		       	 	b[2][4]=1;
		        }
		        else if(b[2][4]==1){
		        	B[2][4].setBackgroundColor(Color.BLUE);
		        	b[2][4]=0;
		        }		 
	        }
        });
        
        B[3][0] = (Button)findViewById(R.id.boton41);
        B[3][0].setOnClickListener(new View.OnClickListener() {        
        @Override
	        public void onClick(View v) {
		        if(b[3][0]==0){
		       	 	B[3][0].setBackgroundColor(Color.GREEN);
		       	 	b[3][0]=1;
		        }
		        else if(b[3][0]==1){
		        	B[3][0].setBackgroundColor(Color.BLUE);
		        	b[3][0]=0;
		        }		 
	        }
        });
        
        B[3][1] = (Button)findViewById(R.id.boton42);
        B[3][1].setOnClickListener(new View.OnClickListener() {        
        @Override
	        public void onClick(View v) {
		        if(b[3][1]==0){
		       	 	B[3][1].setBackgroundColor(Color.GREEN);
		       	 	b[3][1]=1;
		        }
		        else if(b[3][1]==1){
		        	B[3][1].setBackgroundColor(Color.BLUE);
		        	b[3][1]=0;
		        }		 
	        }
        });
        
        B[3][2] = (Button)findViewById(R.id.boton43);
        B[3][2].setOnClickListener(new View.OnClickListener() {        
        @Override
	        public void onClick(View v) {
		        if(b[3][2]==0){
		       	 	B[3][2].setBackgroundColor(Color.GREEN);
		       	 	b[3][2]=1;
		        }
		        else if(b[3][2]==1){
		        	B[3][2].setBackgroundColor(Color.BLUE);
		        	b[3][2]=0;
		        }		 
	        }
        });
        
        B[3][3] = (Button)findViewById(R.id.boton44);
        B[3][3].setOnClickListener(new View.OnClickListener() {        
        @Override
	        public void onClick(View v) {
		        if(b[3][3]==0){
		       	 	B[3][3].setBackgroundColor(Color.GREEN);
		       	 	b[3][3]=1;
		        }
		        else if(b[3][3]==1){
		        	B[3][3].setBackgroundColor(Color.BLUE);
		        	b[3][3]=0;
		        }		 
	        }
        });
        
        B[3][4] = (Button)findViewById(R.id.boton45);
        B[3][4].setOnClickListener(new View.OnClickListener() {        
        @Override
	        public void onClick(View v) {
		        if(b[3][4]==0){
		       	 	B[3][4].setBackgroundColor(Color.GREEN);
		       	 	b[3][4]=1;
		        }
		        else if(b[3][4]==1){
		        	B[3][4].setBackgroundColor(Color.BLUE);
		        	b[3][4]=0;
		        }		 
	        }
        });
        
        B[4][0] = (Button)findViewById(R.id.boton51);
        B[4][0].setOnClickListener(new View.OnClickListener() {        
        @Override
	        public void onClick(View v) {
		        if(b[4][0]==0){
		       	 	B[4][0].setBackgroundColor(Color.GREEN);
		       	 	b[4][0]=1;
		        }
		        else if(b[4][0]==1){
		        	B[4][0].setBackgroundColor(Color.BLUE);
		        	b[4][0]=0;
		        }		 
	        }
        });
        
        B[4][1] = (Button)findViewById(R.id.boton52);
        B[4][1].setOnClickListener(new View.OnClickListener() {        
        @Override
	        public void onClick(View v) {
		        if(b[4][1]==0){
		       	 	B[4][1].setBackgroundColor(Color.GREEN);
		       	 	b[4][1]=1;
		        }
		        else if(b[4][1]==1){
		        	B[4][1].setBackgroundColor(Color.BLUE);
		        	b[4][1]=0;
		        }		 
	        }
        });
        B[4][2] = (Button)findViewById(R.id.boton53);
        B[4][2].setOnClickListener(new View.OnClickListener() {        
        @Override
	        public void onClick(View v) {
		        if(b[4][2]==0){
		       	 	B[4][2].setBackgroundColor(Color.GREEN);
		       	 	b[4][2]=1;
		        }
		        else if(b[4][2]==1){
		        	B[4][2].setBackgroundColor(Color.BLUE);
		        	b[4][2]=0;
		        }		 
	        }
        });
        B[4][3] = (Button)findViewById(R.id.boton54);
        B[4][3].setOnClickListener(new View.OnClickListener() {        
        @Override
	        public void onClick(View v) {
		        if(b[4][3]==0){
		       	 	B[4][3].setBackgroundColor(Color.GREEN);
		       	 	b[4][3]=1;
		        }
		        else if(b[4][3]==1){
		        	B[4][3].setBackgroundColor(Color.BLUE);
		        	b[4][3]=0;
		        }		 
	        }
        });
        
        B[4][4] = (Button)findViewById(R.id.boton55);
        B[4][4].setOnClickListener(new View.OnClickListener() {        
        @Override
	        public void onClick(View v) {
		        if(b[4][4]==0){
		       	 	B[4][4].setBackgroundColor(Color.GREEN);
		       	 	b[4][4]=1;
		        }
		        else if(b[4][4]==1){
		        	B[4][4].setBackgroundColor(Color.BLUE);
		        	b[4][4]=0;
		        }		 
	        }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
