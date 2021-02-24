package challenge;

public class CriptografiaCesariana implements Criptografia {

@Override
    public String criptografar(String texto) {

    if (texto.equals("")) throw new IllegalArgumentException("Texto esta vazio");
    if (texto == null) throw new NullPointerException("Não é um texto!");

    StringBuilder newText = new StringBuilder();
        int key = 3;
        String lowerCaseText = texto.toLowerCase();

        int textLength = texto.length();



    for(int i=0; i < textLength; i++) {
              int letterAtASCII = (lowerCaseText.charAt(i));
              if(letterAtASCII == ' ') {
                  newText.append(' ');
              } else if( 47 < letterAtASCII && letterAtASCII < 58) {
                  newText.append((char) letterAtASCII);
              } else {
                  int criptoLetter = letterAtASCII + key;
                  newText.append( (char) criptoLetter);
              }
          }
    return newText.toString();
    }

    @Override
    public String descriptografar(String texto) {

        if (texto.equals("")) throw new IllegalArgumentException("Texto esta vazio");
        if (texto == null) throw new NullPointerException("Não é um texto!");


        int key = 3;
        String lowerCaseText = texto.toLowerCase();
        StringBuilder newText = new StringBuilder();

        int textLength = texto.length();


        for(int i=0; i < textLength; i++) {
            int letterAtASCII = (lowerCaseText.charAt(i));
            if(letterAtASCII == ' ') {
                newText.append(' ');
            } else if( 47 < letterAtASCII && letterAtASCII < 58) {
                newText.append((char) letterAtASCII);
            } else {
                int criptoLetter = letterAtASCII - key;
                newText.append( (char) criptoLetter);
            }
        }
        return newText.toString();
    }

}
