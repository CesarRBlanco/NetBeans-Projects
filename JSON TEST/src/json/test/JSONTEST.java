package json.test;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonValue;

public class JSONTEST {

    public static JsonValue creaArray() {
        JsonArray array = (JsonArray) Json.createArrayBuilder()
                .add(Json.createObjectBuilder()
                        .add("titulo", "El atlas de las nubes")
                        .add("año", 2012)
                        .add("directores", "Lana Wachowski, Tom Tykwer, Andy Wachowski")
                        .add("interpretes", Json.createArrayBuilder()
                                .add(Json.createObjectBuilder()
                                        .add("nombre", "Tom Hanks")
                                        .add("fechaNacimiento", Json.createObjectBuilder()
                                                .add("año", "1956")
                                                .add("mes", 8)
                                        )
                                )
                                .add(Json.createObjectBuilder()
                                        .add("nombre", "Halle Berry")
                                        .add("fechaNacimiento", Json.createObjectBuilder()
                                                .add("año", "1966")
                                                .add("mes", 7)
                                        )
                                )
                        )
                )
                .add(Json.createObjectBuilder()
                        .add("titulo", "La red social")
                        .add("año", 2010)
                        .add("directores", "David Fincher")
                        .add("interpretes", Json.createArrayBuilder()
                                .add(Json.createObjectBuilder()
                                        .add("nombre", "Jesse Eisenberg")
                                        .add("fechaNacimiento", Json.createObjectBuilder()
                                                .add("año", "1983")
                                                .add("mes", 9)
                                        )
                                )
                                .add(Json.createObjectBuilder()
                                        .add("nombre", "Andrew Garfield")
                                        .add("fechaNacimiento", Json.createObjectBuilder()
                                                .add("año", "1983")
                                                .add("mes", 7)
                                        )
                                )
                        )
                )
                .build();
        return array;
    }

    public static void main(String[] args) {

        JsonValue jv = creaArray();

        JsonArray array = (JsonArray) jv;

//        System.out.println(array.size());
        for (JsonObject obj : array.getValuesAs(JsonObject.class)) {

            JsonArray arrayInter = obj.getJsonArray("interpretes");
            for (JsonObject objInter : arrayInter.getValuesAs(JsonObject.class)) {
              
                
                
                if (objInter.getJsonObject("fechaNacimiento").getInt("mes") == 9) {
                    System.out.println(objInter.getString("nombre"));
                    System.out.println(obj.getString("titulo"));
                    System.out.println(objInter.getString("nombre"));
                    System.out.println(obj.getInt("año"));
                    System.out.println(objInter.getJsonObject("fechaNacimiento").getInt("mes"));
                }
            }
        }

//        for (int i = 0; i < array.size(); i++) {
//            JsonObject obj=array.get(index);
//        }
    }

}
