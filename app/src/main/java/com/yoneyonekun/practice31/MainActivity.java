package com.yoneyonekun.practice31;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String opText;
    String outText;


    boolean afterOp;
    boolean isStacked;
    Float StackedValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //「1」ボタンの結び付けとリスナーをセット
        Button bt1Click = findViewById(R.id.bt_1);
        ButtonClick bt1listener = new ButtonClick();
        bt1Click.setOnClickListener(bt1listener);

        //「2」ボタンの結び付けとリスナーをセット
        Button bt2Click = findViewById(R.id.bt_2);
        ButtonClick bt2listener = new ButtonClick();
        bt2Click.setOnClickListener(bt2listener);

        //「3」ボタンの結び付けとリスナーをセット
        Button bt3Click = findViewById(R.id.bt_3);
        ButtonClick bt3listener = new ButtonClick();
        bt3Click.setOnClickListener(bt3listener);

        //「4」ボタンの結び付けとリスナーをセット
        Button bt4Click = findViewById(R.id.bt_4);
        ButtonClick bt4listener = new ButtonClick();
        bt4Click.setOnClickListener(bt4listener);

        //「5」ボタンの結び付けとリスナーをセット
        Button bt5Click = findViewById(R.id.bt_5);
        ButtonClick bt5listener = new ButtonClick();
        bt5Click.setOnClickListener(bt5listener);

        //「6」ボタンの結び付けとリスナーをセット
        Button bt6Click = findViewById(R.id.bt_6);
        ButtonClick bt6listener = new ButtonClick();
        bt6Click.setOnClickListener(bt6listener);

        //「7」ボタンの結び付けとリスナーをセット
        Button bt7Click = findViewById(R.id.bt_7);
        ButtonClick bt7listener = new ButtonClick();
        bt7Click.setOnClickListener(bt7listener);

        //「8」ボタンの結び付けとリスナーをセット
        Button bt8Click = findViewById(R.id.bt_8);
        ButtonClick bt8listener = new ButtonClick();
        bt8Click.setOnClickListener(bt8listener);

        //「9」ボタンの結び付けとリスナーをセット
        Button bt9Click = findViewById(R.id.bt_9);
        ButtonClick bt9listener = new ButtonClick();
        bt9Click.setOnClickListener(bt9listener);

        //「0」ボタンの結び付けとリスナーをセット
        Button bt0Click = findViewById(R.id.bt_0);
        ButtonClick bt0listener = new ButtonClick();
        bt0Click.setOnClickListener(bt0listener);

        //「+」ボタンの結び付けとリスナーをセット
        Button btpClick = findViewById(R.id.bt_plus);
        ButtonClick btplistener = new ButtonClick();
        btpClick.setOnClickListener(btplistener);

        //「-」ボタンの結び付けとリスナーをセット
        Button btmClick = findViewById(R.id.bt_minus);
        ButtonClick btmlistener = new ButtonClick();
        btmClick.setOnClickListener(btmlistener);

        //「×」ボタンの結び付けとリスナーをセット
        Button btbClick = findViewById(R.id.bt_mul);
        ButtonClick btblistener = new ButtonClick();
        btbClick.setOnClickListener(btblistener);

        //「÷」ボタンの結び付けとリスナーをセット
        Button btdClick = findViewById(R.id.bt_div);
        ButtonClick btdlistener = new ButtonClick();
        btdClick.setOnClickListener(btdlistener);

        //「=」ボタンの結び付けとリスナーをセット
        Button bteClick = findViewById(R.id.bt_equal);
        ButtonClick btelistener = new ButtonClick();
        bteClick.setOnClickListener(btelistener);

        //「.」ボタンの結び付けとリスナーをセット
        Button btpeClick = findViewById(R.id.bt_dot);
        ButtonClick btpelistener = new ButtonClick();
        btpeClick.setOnClickListener(btpelistener);

        //「C」ボタンの結び付けとリスナーをセット
        Button btcClick = findViewById(R.id.bt_C);
        ButtonClick btclistener = new ButtonClick();
        btcClick.setOnClickListener(btclistener);
    }

    /**
     *数値及び記号ボタン押下時の処理
     * ButtonClick()
     */
    private class ButtonClick implements View.OnClickListener {

        //入力された数値が表示される場所
        TextView output = findViewById(R.id.cul);


        //入力値に対する処理
        void appendText(String t) {

            //表示されている文字をoutTextに格納
            outText = output.getText().toString();

            //afterOp=falseまたは"0"以外の数字が表示されているとき
            if (!afterOp && !(outText.equals("0"))) {

                //文字列として値を追加(右側へ)
                t = outText + t;

                //"."が入力されたとき
            } else if (t.equals(".")) {

                //"0."で始まる数字になる
                t = "0" + t;
            }

            //今入力された数値を表示する("0"が表示されている場合は0にとって代わってその数字を表示)
            output.setText(t);
            afterOp = false;        //文字入力続行を可能にする


        }

        //演算子の処理
        void Calculation(String o, Float s) {

            Float r = 0.0f;     //計算結果

            //各々入力された数値(文字列)をFloat型に変更して計算
            //sは演算子を入力する前に入力されていた数値
            if (o.equals("＋")) {
                r = s + Float.parseFloat(output.getText().toString());

            } else if (o.equals("-")) {
                r = s - Float.parseFloat(output.getText().toString());

            } else if (o.equals("×")) {
                r = s * Float.parseFloat(output.getText().toString());

            } else if (o.equals("÷")) {
                r = s / Float.parseFloat(output.getText().toString());

            }


            //もし”ｒ”が整数なら
            if (r == r.intValue()) {

                //int型の数値をString型の文字列に変えて”output”に格納
                output.setText(String.valueOf(r.intValue()));
            } else {

                //小数込みの実数を”output”へ格納
                output.setText(r.toString());
            }
        }

        //ボタン押下時処理
        @Override
        public void onClick(View v) {

            String apText;

            int id = v.getId();     //押したボタンのidを取得(ボタンをidで判別)

            //押されたボタンについての処理を行う
            Button btn = (Button) v;

            switch (id) {

                //数字押下時
                case R.id.bt_0:
                case R.id.bt_1:
                case R.id.bt_2:
                case R.id.bt_3:
                case R.id.bt_4:
                case R.id.bt_5:
                case R.id.bt_6:
                case R.id.bt_7:
                case R.id.bt_8:
                case R.id.bt_9:

                    //apTextは入力されたボタンの数値を読み取る
                    apText = btn.getText().toString();

                    //appendTextに入力されてた数値を送る
                    appendText(apText);

                    break;

                //演算子押下時
                case R.id.bt_plus:
                case R.id.bt_minus:
                case R.id.bt_mul:
                case R.id.bt_div:

                    //1巡目はスルー（Calculationでの処理は行わない）
                    if (isStacked) {

                        //opTextは文字列（＋、ー、×、÷、＝、C）を格納する
                        Calculation(opText, StackedValue);
                    }

                    //StackedValueに入力された実数を格納
                    StackedValue = Float.parseFloat(output.getText().toString());

                    //2巡目以降に向けての準備
                    isStacked = true;

                    afterOp = true;

                    //btnの文字列を読みとり、opTextに格納(2巡目以降のCalculationで使用)
                    //※apTextは数字のみ
                    opText = btn.getText().toString();

                    break;

                //"＝"押下時処理
                case R.id.bt_equal:
                    if (isStacked) {
                        Calculation(opText, StackedValue);
                    }

                    //周回カウントをリセットする（また1巡目からの処理となる）
                    isStacked = false;

                    //"＝"押下後数字を入力することができないようにするためのフラグ
                    afterOp = true;
                    break;

                //"."押下時処理
                case R.id.bt_dot:
                    String dplText;
                    dplText = output.getText().toString();

                    //数値に”.”が含まれていなかったら
                    if (!dplText.contains(".")) {

                        //「ｔ＝ｔ＋”.”」の式で"."が追加される
                        appendText(".");
                    }
                    break;

                //"C"押下時処理
                case R.id.bt_C:

                    //条件全てリセット
                    output.setText("0");
                    isStacked = false;
                    afterOp = false;
                    StackedValue = null;
                    break;


            }

        }
    }
}
