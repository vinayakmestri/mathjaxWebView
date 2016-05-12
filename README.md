# MathJaxView

<img src="screenshot/screenshot.png" width="250">

## Setup



```xml
<LinearLayout ...>

    <TextView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Formula one: from xml with MathJax"
        android:textStyle="bold"/>

    <io.github.kexanie.library.MathView
        android:id="@+id/formula_one"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        auto:text="When \\(a \\ne 0\\), there are two solutions to \\(ax^2 + bx + c = 0\\)
        and they are $$x = {-b \\pm \\sqrt{b^2-4ac} \\over 2a}.$$"
        auto:engine="MathJax"
        >
    </io.github.kexanie.library.MathView>

    <TextView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Formula two: from Java String with KaTeX"
        android:textStyle="bold"/>

    <io.github.kexanie.library.MathView
        android:id="@+id/formula_two"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        auto:engine="KaTeX"
        >
    </io.github.kexanie.library.MathView>

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

        formula_two = (MathView) findViewById(R.id.formula_two);
        formula_two.setText(tex);
    }
}
```


