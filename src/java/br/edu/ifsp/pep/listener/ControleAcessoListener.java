package br.edu.ifsp.pep.listener;

import br.edu.ifsp.pep.controller.LoginController;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.PhaseEvent;
import jakarta.faces.event.PhaseId;
import jakarta.faces.event.PhaseListener;
import jakarta.inject.Inject;
import java.io.IOException;

public class ControleAcessoListener implements PhaseListener {

    @Inject
    private LoginController loginController;

    @Override
    public void afterPhase(PhaseEvent event) {
        System.out.println("Após a fase: " + event.getPhaseId());

        FacesContext ctx = event.getFacesContext();
        String pagina = ctx.getViewRoot().getViewId();
        System.out.println("Página atual: " + pagina);

        // Se a página for 'venda/criar.xhtml', verifica se o usuário está logado
        if (pagina.equals("/venda/criar.xhtml")) {
            if (loginController.getPessoaLogada() == null) {
                System.out.println("Pessoa não autenticada. Redirecionando para acesso-negado.xhtml");
                redirecionar(ctx, "/acesso-negado.xhtml");
            }
        }
    }

    private void redirecionar(FacesContext ctx, String pagina) {
        try {
            // Obtém o contexto da requisição
            String projeto = ctx.getExternalContext().getRequestContextPath();

            // Realiza o redirecionamento para a página especificada
            ctx.getExternalContext().redirect(projeto + pagina);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void beforePhase(PhaseEvent event) {
        System.out.println("Antes da fase: " + event.getPhaseId());
    }

    @Override
    public PhaseId getPhaseId() {
        // A fase pode ser 'ANY_PHASE' para ouvir todos os eventos ou uma fase específica
        return PhaseId.ANY_PHASE;
    }
}
