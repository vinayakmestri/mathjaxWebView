# MathJaxWebView

<img src="screenshots/screen.png" width="250">

## Setup



```xml
<LinearLayout ...>

    <vinos.mathjaxwebview.view.MathJaxWebView
        android:id="@+id/webView"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
         />

</LinearLayout>

```

### Get an instance from your `Activity`
```java
public class MainActivity extends AppCompatActivity {
    MathJaxWebView mathJaxWebView;
    String tex = "This come from string. You can insert inline formula:" +
            " \\(ax^2 + bx + c = 0\\) " +
            "or displayed formula: $$\\sum_{i=0}^n i^2 = \\frac{(n^2+n)(2n+1)}{6}$$";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mathJaxWebView =(MathJaxWebView)findViewById(R.id.webView);
        mathJaxWebView.getSettings().setJavaScriptEnabled(true);
        mathJaxWebView.setText(tex);


    }

    @Override
    protected void onResume() {
        super.onResume();

    }
}
```