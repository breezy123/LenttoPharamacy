package LentoPharmacy.co.za.service;

/**
 * Created by aubrey on 17/08/2017.
 */
public interface BaseService<E,ID> {

    E save(E id);
    E findById(ID id);
    E update(E id);

    void delete(E id);
}
