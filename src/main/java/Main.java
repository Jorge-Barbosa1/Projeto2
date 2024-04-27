import BLL.*;
import Entity.AdministradorEntity;

import static BLL.AdministratorBLL.findAdmin;

public class Main {
    public static void main(String[] args) {
        //TESTES

        AdministradorEntity adm = findAdmin(10);
        System.out.println(adm.getNome());

    }
}