package troubleShootSearch.util;

import java.util.List;

import troubleShootSearch.conditionModule.Visitor;

public class Productversion {

    private List<String> troubleShooterlist = null;

    public Productversion() {
//        troubleShooterlist = product.getProduct1().getContentList();
    }
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public List<String> getTroubleShooterlist() {
        return troubleShooterlist;
    }
    public void setTroubleShooterlist(List<String> troubleShooterlist) {
        this.troubleShooterlist = troubleShooterlist;
    }
}