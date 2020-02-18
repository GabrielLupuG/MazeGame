import javax.security.auth.Subject;

public class CurrentConditionsDisplay  {
        private float temperature;
        private float humidity;
        private Subject weatherData;
       
        public CurrentConditionsDisplay(Subject weatherData) {
                this.setWeatherData(weatherData);
                weatherData.registerObserver(this);
        }
       
        public void update(float temperature, float humidity, float pressure) {
                this.temperature = temperature;
                this.humidity = humidity;
                display();
        }
       
        public void display() {
                System.out.println("Current conditions: " + temperature
                        + "F degrees and " + humidity + "% humidity");
        }

		public Subject getWeatherData() {
			return weatherData;
		}

		public void setWeatherData(Subject weatherData) {
			this.weatherData = weatherData;
		}
}

