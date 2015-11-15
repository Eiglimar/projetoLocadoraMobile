package locadora.usjt.com.br.locadoraoficial;

/**
 * Created by Eiglimar on 12/11/15.
 */
public class ResponseVeiculoDetalhe {

    /**
     * kmControlado : 22
     * kmLivre : 11
     */

    private AutomovelTOEntity automovelTO;

    public void setAutomovelTO(AutomovelTOEntity automovelTO) {
        this.automovelTO = automovelTO;
    }

    public AutomovelTOEntity getAutomovelTO() {
        return automovelTO;
    }

    public static class AutomovelTOEntity {
        private String kmControlado;
        private String kmLivre;

        public void setKmControlado(String kmControlado) {
            this.kmControlado = kmControlado;
        }

        public void setKmLivre(String kmLivre) {
            this.kmLivre = kmLivre;
        }

        public String getKmControlado() {
            return kmControlado;
        }

        public String getKmLivre() {
            return kmLivre;
        }
    }
}
