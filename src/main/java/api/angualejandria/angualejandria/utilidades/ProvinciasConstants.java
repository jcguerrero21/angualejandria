package api.angualejandria.angualejandria.utilidades;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Juan Carlos on 24/11/2017.
 */
public class ProvinciasConstants {

    public final static String PRO = "PRO";

    //50 Pronvincias
    public final static Map<String, String> mapOfProvincias = new HashMap<String, String>() {
        {
            put("ALV", "�LAVA");
            put("ALB", "ALBACETE");
            put("ALI", "ALICANTE");
            put("ALM", "ALMER�A");
            put("AST", "ASTURIAS");
            put("AVL", "�VILA");
            put("BAD", "BADAJOZ");
            put("BAR", "BARCELONA");
            put("BUR", "BURGOS");
            put("CAC", "C�CERES");
            put("CAD", "C�DIZ");
            put("CAN", "CANTABRIA");
            put("CAS", "CASTELL�N");
            put("CIR", "CIUDAD REAL");
            put("COR", "C�RDOBA");
            put("CUE", "CUENCA");
            put("GER", "GERONA");
            put("GRA", "GRANADA");
            put("GUA", "GUADALAJARA");
            put("GUI", "GUIPUZKOA");
            put("HUE", "HUELVA");
            put("HUS", "HUESCA");
            put("ISB", "ISLAS BALEARES");
            put("JAE", "JA�N");
            put("LAC", "LA CORU�A");
            put("LAR", "LA RIOJA");
            put("LAP", "LAS PALMAS");
            put("LEO", "LE�N");
            put("LER", "L�RIDA");
            put("LUG", "LUGO");
            put("MAD", "MADRID");
            put("MAL", "M�LAGA");
            put("MUR", "MURCIA");
            put("NAV", "NAVARRA");
            put("ORE", "ORENSE");
            put("PAL", "PALENCIA");
            put("PON", "PONTEVEDRA");
            put("SAL", "SALAMANCA");
            put("SEG", "SEGOVIA");
            put("SEV", "SEVILLA");
            put("SOR", "SORIA");
            put("TAR", "TARRAGONA");
            put("TEN", "TENERIFE");
            put("TER", "TERUEL");
            put("TOL", "TOLEDO");
            put("VAL", "VALENCIA");
            put("VLL", "VALLADOLID");
            put("VIZ", "VIZCAYA");
            put("ZAM", "ZAMORRA");
            put("ZAR", "ZARAGOZA");
        }
    };

    public final static List<String> listOfProvinciasCode = new ArrayList<>(mapOfProvincias.keySet());
    public final static List<String> getListOfProvinciasNombre = new ArrayList<>(mapOfProvincias.values());

}
