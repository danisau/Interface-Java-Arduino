#include <LiquidCrystal.h>            // incluimos la libreria LCD
LiquidCrystal lcd(12, 11, 5, 4, 3, 2);// inicializamos los pines 
String msg="";
char input;
int Ana1 = A0; //Entrada analogica de LM35
int Temp = 0;
char Grados = 'C';
 
void setup() {
  //Iniciamos la comunicación con el puerto serie
  lcd.begin(16, 2);                
  pinMode(10,OUTPUT);     
  //Cofiguramos el tamaño de la LCD
  Serial.begin(9600);
}

void loop() {
  //En caso que haya información en el Serial Port, se entra en esta estructura
  if (Serial.available()) {
    input = Serial.read();
    msg += input;
    if(input == '2'){
        lcd.clear();
        Temp = analogRead(Ana1); //Leemos el valor de la entrada analogica 
        // Primero transformamos la lectura analógica de tensión a un valor de temperatura
        Temp = (5.0 * Temp * 100.0)/1024.0;
        Serial.print("Grados: ");//Mostramos los grados en el serial
        Serial.print(Temp);
        Serial.print(Grados);
        Serial.println("C");
        
        //Mostramos los grados en la pantalla LCD
        lcd.setCursor(1,0); //Con este comando decimos en que linea queremos escribir
        lcd.print("Temp: ");
        lcd.print(Temp);
        lcd.print(" C");
        delay(1000); //Al ser temperatura no hace falta leerlo tan seguido
        msg="";
    } else {
          lcd.clear();
          lcd.print(msg); 
        }
    }
}

