### statuses:
[![Actions Status](https://github.com/zoyart/java-project-78/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/zoyart/java-project-78/actions) [![Makefile Workflow Status](https://github.com/zoyart/java-project-78/actions/workflows/makefile.yml/badge.svg)](https://github.com/zoyart/java-project-78/actions/workflows/makefile.yml) [![Maintainability](https://api.codeclimate.com/v1/badges/b4f1803ce8698df6a1a2/maintainability)](https://codeclimate.com/github/zoyart/java-project-78/maintainability) [![Test Coverage](https://api.codeclimate.com/v1/badges/b4f1803ce8698df6a1a2/test_coverage)](https://codeclimate.com/github/zoyart/java-project-78/test_coverage)

# Data  Validator
Supports  validation of data  types  such  as:
1. Integer/Float;
2. String;
3. Map.

As  well  as  processing the values of the  keys  in the Map.

**Features**

If the **value is null** and there is **no required rule**, then **all** instructions will be validated automatically.
# Usage
***Create validation schema***
```java
Validator v = new Validator();

NumberSchema num = v.number();
StringSchema str = v.string();
MapSchema map = v.<T,R>map();
```
***Use rules***
```java
StringSchema strRules = str.required().minLength(3);  
boolean isValid = strRules.isValid("Some text");

// or 

boolean isValid = str.required().minLength(3).isValid("Some text"); // true
```
**1. Integer/Float**

*Validation  rules:*
* ```required()``` - the number must  **not**  be  equal to **null**;
* ```positive()``` - is the number positive;
* ```range(1, 3)``` - is the number in the specified range, from  1  to  3  including.

**2. String**

*Validation rules:*
* ```required()``` - the string must  **not**  be  equal to **null**;
* ```contains("subStr")``` - the specified substring must be in the string;
* ```minLength(5)``` - the length of the string  must  be  greater than or  equal to the specified length.

**2. Map**

*Validation rules:*
* ```required()``` - the map must  **not**  be  equal to **null**;
* ```sizeof(2)``` - the map must be of the specified size.

**You  can also create  rules  for the key  value  in the Map:**
  ```java
Validator v = new Validator();  
MapSchema<String, String> schema = v.map();  
  
Map<String, BaseSchema<String>> schemas = new HashMap<>();  
schemas.put("firstName", v.string().required());  
schemas.put("lastName", v.string().required().minLength(2));  
  
schema.shape(schemas);  
  
Map<String, String> human1 = new HashMap<>();  
human1.put("firstName", "John");  
human1.put("lastName", "Smith");  
schema.isValid(human1); // true
```
You can use:
* for keys - Integer &Float & String
* for values -  Integer & String & Map
  
  
  

