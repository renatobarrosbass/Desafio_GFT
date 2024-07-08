package step_definitions;

import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.restassured.response.Response;
import service.catApiService;

public class catApiStepDefinitions {
    private Response response;
    @Quando("envio request Post catApi")
    public void envio_request_post_cat_api() {
        response = catApiService.enviarPostCatApi();

    }
    @Entao("verifico se gato foi criado")
    public void verifico_se_gato_foi_criado() {
        catApiService.validarPostCatApiCriado(response);
    }

    @Quando("envio post catApi sem corpo")
    public void envio_post_cat_api_sem_corpo() {
        response = catApiService.enviarPostCatApiSemBody();
    }
    @Entao("verifico se a API retorna erro de requisição invalida")
    public void verifico_se_a_api_retorna_erro_de_requisicao_invalida() {
        catApiService.validarRetornoPostCatApiSemBody(response);
    }

    @Quando("envio post catApi com corpo vazio")
    public void envio_post_cat_api_com_corpo_vazio() {
        response = catApiService.enviarPostCatApiComBodyVazio();
    }

    @Quando("envio request Get catApi")
    public void envio_request_get_cat_api() {
        response = catApiService.enviarGetGeralCatApi();
    }
    @Entao("verifico se retornou a lista de gatos")
    public void verifico_se_retornou_a_lista_de_gatos() {
        catApiService.validarRetornoGetAllCatApi(response);
    }

    @Quando("envio request Get-Id catApi")
    public void envio_request_get_id_cat_api() {
        response = catApiService.enviarGetIdCatApi();
    }
    @Entao("verifico se retornou a lista com o id do registro especifico de gatos")
    public void verifico_se_retornou_a_lista_com_o_id_do_registro_especifico_de_gatos() {
        catApiService.validarGetCatApiPorId(response);
    }


}
