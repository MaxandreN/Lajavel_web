package app.repository;

import app.models.Partner;

import java.util.List;

public class PartnersRepository {
    private static PartnersRepository instance;
    private List<Partner> partnerlist;

    private PartnersRepository() {
        Partner partner = new Partner("intermarché", "Gueugnon", "/img/partners/intermarche.png", "intermarché");
        Partner partner2 = new Partner("Digoin Ceramic Museum", "", "/img/partners/Musee_Ceramique_Digoin.png", "Digoin Ceramic Museum");
        Partner partner3 = new Partner("larovel", "", "/img/partners/larovel.png", "larovel");
        Partner partner4 = new Partner("And why not you ?", "", "/img/partners/come_on.jpg", "larovel");

        this.partnerlist = List.of(partner, partner2, partner3, partner4);
    }

    public static PartnersRepository getInstance() {
        if (instance == null) {
            instance = new PartnersRepository();
        }
        return instance;
    }

    public static List<Partner> findall(){
        return PartnersRepository.getInstance().partnerlist;
    }
}
