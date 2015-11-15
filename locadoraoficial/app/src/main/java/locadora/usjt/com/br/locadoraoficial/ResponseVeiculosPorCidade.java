package locadora.usjt.com.br.locadoraoficial;

import java.util.List;

/**
 * Created by Eiglimar on 12/11/15.
 */
public class ResponseVeiculosPorCidade {
    /**
     * fabricante : AUDI
     * imagem : http://s2.glbimg.com/oAVJIUIrSMEbwEC3SslO42aMOqM=/s.glbimg.com/jo/g1/f/original/2014/04/22/a3.jpg
     * modelo : A3
     */

    private List<AutomovelTOEntity> automovelTO;

    public void setAutomovelTO(List<AutomovelTOEntity> automovelTO) {
        this.automovelTO = automovelTO;
    }

    public List<AutomovelTOEntity> getAutomovelTO() {
        return automovelTO;
    }

    public static class AutomovelTOEntity {
        private String fabricante;
        private String imagem;
        private String modelo;

        public void setFabricante(String fabricante) {
            this.fabricante = fabricante;
        }

        public void setImagem(String imagem) {
            this.imagem = imagem;
        }

        public void setModelo(String modelo) {
            this.modelo = modelo;
        }

        public String getFabricante() {
            return fabricante;
        }

        public String getImagem() {
            return imagem;
        }

        public String getModelo() {
            return modelo;
        }
    }
}
