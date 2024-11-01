public class Ascii {
    
    public static void drawD20(int value) {
       String d20 = String.format("            ,:::,\r\n" + //
                      "       ,,,:;  :  ;:,,, \r\n" + //
                      "   ,,,:       :       :,,, \r\n" + //
                      ",,;...........:...........;,,\r\n" + //
                      "; ;          ;';          ; ;\r\n" + //
                      ";  ;        ;   ;        ;  ;\r\n" + //
                      ";   ;      ;     ;      ;   ;\r\n" + //
                      ";    ;    ;       ;    ;    ;\r\n" + //
                      ";     ;  ;   %s    ;  ;     ;\r\n" + //
                      ";      ;:...........:;      ;\r\n" + //
                      ";     , ;           ; ,     ;\r\n" + //
                      ";   ,'   ;         ;   ',   ;\r\n" + //
                      "'';'      ;       ;      ';''\r\n" + //
                      "   ''';    ;     ;    ;'''         \r\n" + //
                      "       ''':;;   ;;:'''\r\n" + //
                      "            ':::'", value);
        System.out.println(d20);
    }

    public static void drawD4(int value) {
        String d4 = String.format("          ;;\r\n" + //
                        "        ,;  ;,\r\n" + //
                        "       ,;    ;,\r\n" + //
                        "      ,;      ;,\r\n" + //
                        "     ,;        ;,\r\n" + //
                        "    ,;          ;, \r\n" + //
                        "   ,;     %s      ;,\r\n" + //
                        "  ,;              ;,\r\n" + //
                        " ,;                ;, \r\n" + //
                        ",;                  ;,\r\n" + //
                        "::::::::::::::::::::::", value);
        System.out.println(d4);
    }
}
