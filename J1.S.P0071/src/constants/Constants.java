/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package constants;

public final class Constants {

    //private Constructor
    private Constants() {
    }

    //Task Type mapping
    public static String getTaskTypeName(int typeId) {
        switch (typeId) {
            case 1:
                return "Code";
            case 2:
                return "Test";
            case 3:
                return "Design";
            case 4:
                return "Review";
            default:
                return "Unknown";
        }
    }
}
