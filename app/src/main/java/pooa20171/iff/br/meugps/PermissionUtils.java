package pooa20171.iff.br.meugps;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by Marcos on 28/08/2017.
 */

public class PermissionUtils {

    public static boolean validate(Activity activity, int requestCode, String... permissions) {
        List<String> list = new ArrayList<String>();
        for (String permission : permissions) {
            // Validar permissão
            //boolean ok = ContextCompat.checkSelfPermission(activity, permission) == PackageManager.PERMISSION_GRANTED;
            if (! (ContextCompat.checkSelfPermission(activity, permission) == PackageManager.PERMISSION_GRANTED) ) {
                list.add(permission);
            }
        }
        if (list.isEmpty()) {
            // Se ok, retorna true
            return true;
        }

        // Lista de permissões que ainda sem acesso.
        String[] newPermissions = new String[list.size()];
        list.toArray(newPermissions);

        // solicitar permisão
        ActivityCompat.requestPermissions(activity, newPermissions, 1);

        return false;
    }
}
