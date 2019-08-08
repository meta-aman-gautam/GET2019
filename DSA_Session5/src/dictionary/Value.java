package dictionary;

/**
 *For entering key and value inside the value class  .
 *
 * @author Aman Gautam
 * 
 * Dated - 06/08/2019
 *
 */
public class Value {
	
	private String key;
	private String value;
	
	//constructor
	public Value(String key, String value) {
		super();
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
