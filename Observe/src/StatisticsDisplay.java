import java.util.*;

public class StatisticsDisplay {
        private float maxTemp = 0.0f;
        private float minTemp = 200;
        private float tempSum= 0.0f;
        private int numReadings;
        private WeatherData weatherData;

        public StatisticsDisplay(WeatherData weatherData) {
                this.setWeatherData(weatherData);
                weatherData.registerObserver(this);
        }

        public void update(float temp, float humidity, float pressure) {
                tempSum += temp;
                numReadings++;

                if (temp > maxTemp) {
                        maxTemp = temp;
                }
 
                if (temp < minTemp) {
                        minTemp = temp;
                }

                display();
        }

        public void display() {
                System.out.println("Avg/Max/Min temperature = " + (tempSum / numReadings)
                        + "/" + maxTemp + "/" + minTemp);
        }

		public WeatherData getWeatherData() {
			return weatherData;
		}

		public void setWeatherData(WeatherData weatherData) {
			this.weatherData = weatherData;
		}
}
