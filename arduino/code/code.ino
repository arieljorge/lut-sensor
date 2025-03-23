#include <Adafruit_LiquidCrystal.h>
#include <DHT.h>

#define LDR_PIN A0
#define DHTPIN 2
#define DHTTYPE DHT11

Adafruit_LiquidCrystal lcd(0);

DHT dht(DHTPIN, DHTTYPE);

int ldrValue = 0;

float umidade = 0;
float temperatura = 0;
float luminosidade = 0;

char bufferLuminosidade[4] = {0};
char bufferTemperatura[4] = {0};
char bufferUmidade[4] = {0};

void setup()
{
  lcd.begin(16, 2);
  Serial.begin(9600);
}

void loop()
{
  //Leitura LDR
  ldrValue = analogRead(LDR_PIN);
  luminosidade = (ldrValue / 1023.0) * 100;
  
  //Leitura DHT
  umidade = dht.readHumidity();
  temperatura = dht.readTemperature();
  
  //Formatar os dados para 3 digitos
  dtostrf(luminosidade, 3, 0, bufferLuminosidade);
  dtostrf(temperatura, 3, 0, bufferTemperatura);
  dtostrf(umidade, 3, 0, bufferUmidade);
  
  //Serial
  Serial.print("{\"luminosidade\":");
  Serial.print(luminosidade);
  Serial.print(",\"umidade\":");
  Serial.print(umidade);
  Serial.print(",\"temperatura\":");
  Serial.print(temperatura);
  Serial.print("}\n");
  
  //LCD
  lcd.setCursor(0, 0);
  lcd.print("TEMP:");
  lcd.print(bufferTemperatura);
  lcd.print("C");
  
  lcd.setCursor(0, 1);
  lcd.print("LM:");
  lcd.print(bufferLuminosidade);
  lcd.print("%");
  lcd.print(" UM:");
  lcd.print(bufferUmidade);
  lcd.print("%");
  
  delay(2000);
}