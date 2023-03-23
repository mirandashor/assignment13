//package Converter;

public class WeightConverter extends ConverterPane {
	
	private String title = "Weight Converter";
	private String[] options = {
			"kg - Kilogram", 
			"lb - Pound",
			"oz - Ounce"
	};
	private String fromUnit;
	private String toUnit;
	private String fromValue;
	
	public WeightConverter() {
		setTitle(title);
		setOptions(options);
		
		button.setOnMouseClicked(event -> {
			
			fromUnit = getFromUnit();
			toUnit = getToUnit();
			fromValue = getValueFrom();
			double value;
			double meterLength;
			double result;
			try {
				value = Double.parseDouble(fromValue);
				if ((meterLength = convertToGram(value, fromUnit)) >= 0) {
					result = convertToUnit(meterLength, toUnit);
					textOut.setText("" + df.format(result));
				} else {
					textOut.setText("Weight can't be lower than zero!");
				}
			} catch (NumberFormatException e) {
				textOut.setText("Bad number");
			}
		});
	}
	
	private double convertToGram(double value, String fromUnit) {
		double result = 0;
		switch (fromUnit) {
		case "kg":
			result = value * 1000;
			break;
		case "lb":
			result = value * 453.59237;
			break;
		case "oz":
			result = value * 28.34952;
			break;
		default:
			textOut.setText("No such Weight Unit");
		}
		return result;
	}	
	
	private double convertToUnit(double value, String toUnit) {
		double result = 0;
		switch(toUnit) {
		case "kg":
			result = value / 1000;
			break;
		case "hg":
		
		case "lb":
			result = value / 453.59237;
			break;
		case "oz":
			result = value / 28.34952;
			break;
		}
		return result;
	}
}