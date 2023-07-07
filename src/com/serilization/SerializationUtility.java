package com.serilization;

import java.io.*;
import java.util.Base64;

public class SerializationUtility {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        AppleProduct macBook = new AppleProduct();
        macBook.headphonePort = "headphonePort2020";
        macBook.thunderboltPort = "thunderboltPort2020";

        String serializedObj = serializeObjectToString(macBook);

        System.out.println("Serialized AppleProduct object to string:");
        System.out.println(serializedObj);

        AppleProduct deserializedObj = (AppleProduct) deSerializeObjectFromString(
                serializedObj);

        System.out.println(
                "Headphone port of AppleProduct:"
                        + deserializedObj.getHeadphonePort());
        System.out.println(
                "Thunderbolt port of AppleProduct:"
                        + deserializedObj.getThunderboltPort());
    }

    public static String serializeObjectToString(Serializable o) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(o);
        oos.close();

        return Base64.getEncoder().encodeToString(baos.toByteArray());
    }

    public static Object deSerializeObjectFromString(String s)
            throws IOException, ClassNotFoundException {

        byte[] data = Base64.getDecoder().decode(s);
        ObjectInputStream ois = new ObjectInputStream(
                new ByteArrayInputStream(data));
        Object o = ois.readObject();
        ois.close();
        return o;
    }
}
