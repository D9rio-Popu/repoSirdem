
package Clases;

import javax.swing.text.*;

public class Validaciones {
     // Limita cantidad de caracteres
    public static class LimiteCaracteres extends PlainDocument {
        private int limite;

        public LimiteCaracteres(int limite) {
            this.limite = limite;
        }

        @Override
        public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
            if (str == null)
                return;

            if ((getLength() + str.length()) <= limite) {
                super.insertString(offset, str, attr);
            }
        }
    }

    // Solo números
    public static class LimiteNumeros extends PlainDocument {
        private int limite;

        public LimiteNumeros(int limite) {
            this.limite = limite;
        }

        @Override
        public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
            if (str == null)
                return;

            if (!str.matches("[0-9]+")) {
                return;
            }

            if ((getLength() + str.length()) <= limite) {
                super.insertString(offset, str, attr);
            }
        }
    }

    // Solo letras
    public static class LimiteSoloLetras extends PlainDocument {
        private int limite;

        public LimiteSoloLetras(int limite) {
            this.limite = limite;
        }

        @Override
        public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
            if (str == null)
                return;

            if (!str.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
                return;
            }

            if ((getLength() + str.length()) <= limite) {
                super.insertString(offset, str, attr);
            }
        }
    }
}
