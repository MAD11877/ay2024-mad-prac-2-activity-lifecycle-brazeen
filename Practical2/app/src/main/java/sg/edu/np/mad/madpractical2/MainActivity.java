package sg.edu.np.mad.madpractical2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import sg.edu.np.mad.madpractical2.User;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //assign user object
        User user1 = new User("Brandon Koh", "I am Brandon Koh from IT07, taking the Software Engineering specialisation.", 1, true);

        //use data from user1
        TextView nameview = findViewById(R.id.TextView2);
        TextView descview = findViewById(R.id.TextView3);
        Button followbtn = findViewById(R.id.Button1);
        nameview.setText(user1.name);
        descview.setText(user1.description);
        followbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (user1.followed){
                    followbtn.setText("UNFOLLOW");
                    user1.followed = false;
                }
                else{
                    followbtn.setText("FOLLOW");
                    user1.followed = true;
                }
            }
        });



    }
}