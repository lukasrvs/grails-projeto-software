package app;

import java.util.InputMismatchException;

public class Validacao {

    public boolean isCNPJ(String CNPJ) {
        if (CNPJ.equals("00000000000000") || CNPJ.equals("11111111111111")
                || CNPJ.equals("22222222222222") || CNPJ.equals("33333333333333")
                || CNPJ.equals("44444444444444") || CNPJ.equals("55555555555555")
                || CNPJ.equals("66666666666666") || CNPJ.equals("77777777777777")
                || CNPJ.equals("88888888888888") || CNPJ.equals("99999999999999")
                || (CNPJ.length() != 14)) {
            return (false);
        }
        try {
            String cnpjBase = CNPJ.substring(0,12);
            String digitosCNPJ = getDigitosCNPJ(cnpjBase);
            if (CNPJ.substring(12,14).equals(digitosCNPJ)) {
                return (true);
            } else {
                return (false);
            }
        } catch (InputMismatchException erro) {
            return (false);
        }
    }
    
    public String getDigitosCNPJ(String CNPJBASE){
        if (CNPJBASE.length() != 12)
            return "";
        
        char dig13, dig14;
        int sm, i, r, num, peso;
        try {
            sm = 0;
            peso = 2;
            for (i = 11; i >= 0; i--) {
                num = (int) (CNPJBASE.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso + 1;
                if (peso == 10) {
                    peso = 2;
                }
            }

            r = sm % 11;
            if ((r == 0) || (r == 1)) {
                dig13 = '0';
            } else {
                dig13 = (char) ((11 - r) + 48);
            }
            CNPJBASE = CNPJBASE + dig13;
            sm = 0;
            peso = 2;
            for (i = 12; i >= 0; i--) {
                num = (int) (CNPJBASE.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso + 1;
                if (peso == 10) {
                    peso = 2;
                }
            }

            r = sm % 11;
            if ((r == 0) || (r == 1)) {
                dig14 = '0';
            } else {
                dig14 = (char) ((11 - r) + 48);
            }
            return String.valueOf(dig13)+String.valueOf(dig14);
        } catch (InputMismatchException erro) {
            return "";
        }
    }

    public String imprimeCpfCnpj(String cpfCnpj) {
        if (cpfCnpj.length() == 11) {
            return (cpfCnpj.substring(0, 3) + "." + cpfCnpj.substring(3, 6) + "."
                    + cpfCnpj.substring(6, 9) + "-" + cpfCnpj.substring(9, 11));
        } else {
            return (cpfCnpj.substring(0, 2) + "." + cpfCnpj.substring(2, 5) + "."
                    + cpfCnpj.substring(5, 8) + "/" + cpfCnpj.substring(8, 12) + "-"
                    + cpfCnpj.substring(12, 14));
        }
    }

    public boolean isCPF(String cpf) {
        int d1, d2;
        int digito1, digito2, resto;
        int digitoCPF;
        String nDigResult;

        // considera-se erro CPF's formados por uma sequencia de numeros iguais
        if (cpf.equals("00000000000") || cpf.equals("11111111111")
                || cpf.equals("22222222222") || cpf.equals("33333333333")
                || cpf.equals("44444444444") || cpf.equals("55555555555")
                || cpf.equals("66666666666") || cpf.equals("77777777777")
                || cpf.equals("88888888888") || cpf.equals("99999999999")
                || (cpf.length() != 11)) {
            return false;
        }

        try { Long teste = Long.parseLong(cpf); } catch(Exception ex) { return false; }

        d1 = d2 = 0;
        digito1 = digito2 = resto = 0;
        for (int nCount = 1; nCount < cpf.length() - 1; nCount++) {
            digitoCPF = Integer.valueOf(cpf.substring(nCount - 1, nCount)).intValue();
            d1 = d1 + (11 - nCount) * digitoCPF;
            d2 = d2 + (12 - nCount) * digitoCPF;
        };
        resto = (d1 % 11);
        if (resto < 2) {
            digito1 = 0;
        } else {
            digito1 = 11 - resto;
        }
        d2 += 2 * digito1;
        resto = (d2 % 11);
        if (resto < 2) {
            digito2 = 0;
        } else {
            digito2 = 11 - resto;
        }
        String nDigVerific = cpf.substring(cpf.length() - 2, cpf.length());
        nDigResult = String.valueOf(digito1) + String.valueOf(digito2);
        return nDigVerific.equals(nDigResult);
    }

    public String formataTelefone(String numero){
        if (numero == null)
            return "";
        else if(numero.length() == 11)
            return String.valueOf(numero).replaceFirst("(\\d{2})(\\d{5})(\\d+)", "($1) $2-$3");
        else
            return String.valueOf(numero).replaceFirst("(\\d{2})(\\d{4})(\\d+)", "($1) $2-$3");
    } 
}