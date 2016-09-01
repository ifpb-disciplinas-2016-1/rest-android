package ifpb.pos.android;

import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TwitterActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twitter);

        // referências


        final EditText nome = (EditText) findViewById(R.id.nome);
        final EditText idade = (EditText) findViewById(R.id.idade);
        final EditText resultado = (EditText) findViewById(R.id.editText2);

        final EditText host = (EditText) findViewById(R.id.editText);
        final EditText port = (EditText) findViewById(R.id.editText4);


        Button post = (Button) findViewById(R.id.button1);
        // eventos e modelos

        // http://localhost:8088/pos-rest-android/api/android
        String path = new StringBuilder("http://")
                .append(host.getText().toString())
                .append(":")
                .append(port.getText().toString())
                .append("/pos-rest-android/api/")
                .toString();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(path)
        .addConverterFactory(GsonConverterFactory.create())
                .build();
        final Twitter twitter =  retrofit.create(Twitter.class);

        final TwitterClientAndroid service =  new TwitterClientAndroid(twitter);

        final int SDK_INT = android.os.Build.VERSION.SDK_INT;

        post.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (SDK_INT > 8){
                    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                            .permitAll().build();
                    StrictMode.setThreadPolicy(policy);
                    resultado.setText(
                            service.lerUsuario(
                                    nome.getText().toString(),
                                    idade.getText().toString()).toString());
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_calculadora, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
