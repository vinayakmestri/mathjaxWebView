package vinos.mathjaxwebview.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;


/**
 * Created by Dell on 25-01-2016.
 */
public class MathJaxWebView extends WebView {

    public MathJaxWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
        getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        clearCache(true);
        getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        setBackgroundColor(Color.TRANSPARENT);
        getSettings().setJavaScriptEnabled(true);
        getSettings().setBuiltInZoomControls(false);
        setHorizontalScrollBarEnabled(false);

    }

    public void setText(final String text)
    {
        /*setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                if (android.os.Build.VERSION.SDK_INT < 19)
                {
                    view.loadUrl("javascript:document.getElementById('math').innerHTML='"
                            + "<math xmlns=\"http://www.w3.org/1998/Math/MathML\">"
                            + "<mstyle displaystyle=\"true\">"
                            + text
                            + "</mstyle></math>';");
                    view.loadUrl("javascript:MathJax.Hub.Queue(['Typeset',MathJax.Hub]);");
                }
                else
                {
                    view.evaluateJavascript("javascript:document.getElementById('math').innerHTML='"
                            + "<math xmlns=\"http://www.w3.org/1998/Math/MathML\">"
                            + "<mstyle displaystyle=\"true\">"
                            + text
                            + "</mstyle></math>';",null);
                    //wq.evaluateJavascript("javascript:document.getElementById('math').innerHTML='<font color=\"#000000\">`"+doubleEscapeTeX(questn+ans)+"`</font>';",null);
                    view.loadUrl("javascript:MathJax.Hub.Queue(['Typeset',MathJax.Hub]);");
                }

            }
        });*/


        loadDataWithBaseURL("http://bar",
                "<script type=\"text/x-mathjax-config\">" +
                        "  MathJax.Hub.Config({" +
                        "extensions: [\"tex2jax.js\"],messageStyle:\"none\"," +
                        "jax: [\"input/TeX\",\"output/HTML-CSS\"]," +
                        "tex2jax: {inlineMath: [['$','$'],['\\\\(','\\\\)']]}" +
                        "});" +
                        "</script>" +
                        "<script type=\"text/javascript\" async src=\"file:///android_asset/MathJax/MathJax.js?config=TeX-AMS-MML_HTMLorMML\"></script>" +
                        "" +
                        "</head>" +
                        "" +
                        "<body>" +
                        text +
                        "</body>" +
                        "</html>", "text/html", "utf-8", "");
        /*if(application.hasInternetConnection()) {
            loadDataWithBaseURL("http://bar",
                    "<script type=\"text/x-mathjax-config\">" +
                            "  MathJax.Hub.Config({" +
                            "extensions: [\"tex2jax.js\"],messageStyle: \"none\"," +
                            "jax: [\"input/TeX\",\"output/HTML-CSS\"]," +
                            "tex2jax: {inlineMath: [['$','$'],[\"\\(\",\"\\)\"]]}" +
                            "});" +
                            "</script>" +
                            "<script type=\"text/javascript\" src=\"http://cdn.mathjax.org/mathjax/latest/MathJax.js?config=TeX-AMS-MML_HTMLorMML\"></script>" +
                            "" +
                            "</head>" +
                            "" +
                            "<body>" +
                            text +
                            "</body>" +
                            "</html>", "text/html", "utf-8", "");
        }
    else {
            loadDataWithBaseURL("http://bar",
                    "<script type=\"text/x-mathjax-config\">" +
                            "  MathJax.Hub.Config({" +
                            "extensions: [\"tex2jax.js\"],messageStyle: \"none\"," +
                            "jax: [\"input/TeX\",\"output/HTML-CSS\"]," +
                            "tex2jax: {inlineMath: [['$','$'],[\"\\(\",\"\\)\"]]}" +
                            "});" +
                            "</script>" +
                            "<script type=\"text/javascript\" src=\"file://android_asset/MathJax/MathJax.js\"></script>" +
                            "" +
                            "</head>" +
                            "" +
                            "<body>" +
                            text +
                            "</body>" +
                            "</html>", "text/html", "utf-8", "");
        }*/
        Log.v("text", text);
    }

}
