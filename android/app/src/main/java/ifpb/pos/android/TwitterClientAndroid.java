package ifpb.pos.android;

import java.io.IOException;

import retrofit2.Response;

/**
 * Created by job on 30/08/16.
 */
public class TwitterClientAndroid {

    private final Twitter service;

    public TwitterClientAndroid(Twitter twitter) {
        this.service = twitter;

    }



    //tratar a UI
    public Usuario lerUsuario(String nome, String idade){
        int valorIdade = Integer.parseInt(idade);
        try {
            Response<Usuario> usuario = service.json(nome, valorIdade).execute();
            return  usuario.body();
        } catch (IOException e) {
            return Usuario.empty();
        }
    }



}
