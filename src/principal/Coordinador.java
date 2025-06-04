package principal;

import dao.PersonaDao;
import vo.PersonaVo;

import java.util.ArrayList;

public class Coordinador {

    private PersonaDao personaDao;

    public Coordinador() {
        personaDao = new PersonaDao();
    }

    public void registrarPersona(PersonaVo persona) {
        personaDao.registrarPersona(persona);
    }

    public ArrayList<PersonaVo> consultarListaPersonas() {
        return personaDao.obtenerListaPersonas();
    }
}
