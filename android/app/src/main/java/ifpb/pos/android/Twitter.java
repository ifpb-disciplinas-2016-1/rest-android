package ifpb.pos.android;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by job on 01/09/16.
 */
public interface Twitter{
    @POST("android")
    @FormUrlEncoded
    Call<Usuario> json(@Field("nome") String nome,@Field("idade") int idade);

}
