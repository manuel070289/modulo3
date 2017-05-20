
package interfaces;

import java.util.List;


public interface Operaciones <Cualquiercosa> {
    public boolean create(Cualquiercosa c);
    public boolean delete(Object key);
    public boolean update(Cualquiercosa c);
    
    public Cualquiercosa read(Object Key);
    public List<Cualquiercosa> readAll();
    
}
