package revature.banking_app.Data;

import java.util.HashMap;

public interface Database<T> {

    HashMap<String, HashMap> read(String userName);
}
