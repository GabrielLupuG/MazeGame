import java.util.*;

public class WeatherData {

        private float temperature;
        private float humidity;
        private float pressure;
       
        public WeatherData() {

        }
       
        public void measurementsChanged() {
                // insert code here
        }
       
        public void setMeasurements(float temperature, float humidity, float pressure) {
                this.temperature = temperature;
                this.humidity = humidity;
                this.pressure = pressure;
                measurementsChanged();
        }
       
        public float getTemperature() {
                return temperature;
        }
       
        public float getHumidity() {
                return humidity;
        }
       
        public float getPressure() {
                return pressure;
        }

		public void registerObserver(ForecastDisplay forecastDisplay) {
			// TODO Auto-generated method stub
			
		}
}

