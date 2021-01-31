package com.example.shoppinglist;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends Activity {
    CheckBox checkBox;
    EditText price;
    TextView count;
    Button minus, plus;

    private ListView listview;
    private ListViewAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainactivity);

        // Adapter 생성
        adapter = new ListViewAdapter();

        // 리스트뷰 참조 및 Adapter 달기
        listview = (ListView) findViewById(R.id.listview);
        listview.setAdapter(adapter);

        // 체크항목, 가격, 개수
        adapter.addItem("true", "감자", "1000원", "1");
        adapter.addItem("true", "고구마", "2000원", "3");
        adapter.addItem("true", "사과", "1500원", "1");
        adapter.addItem("true", "고기", "10000원", "2");

        // 어댑터의 변경 알림.
        adapter.notifyDataSetChanged();

        // add button에 대한 이벤트 처리.
        Button addButton = (Button)findViewById(R.id.add) ;
        addButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {

                // 아이템 추가.
                adapter.addItem("true", "추가고기", "1000원", "1");

                // listview 갱신
                adapter.notifyDataSetChanged();
            }
        }) ;

        // delete button에 대한 이벤트 처리.
        Button deleteButton = (Button)findViewById(R.id.delete) ;
        deleteButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                int count = adapter.getCount() ;
                Log.d("##################전체수 ", count+"");

                for (int i = count-1; i >= 0; i--) {
                    ListViewItem itemData = (ListViewItem) adapter.getItem(i);
                    Log.d("##################아이템 ", itemData + "");
                    if (Boolean.parseBoolean(itemData.getChecked())){
                        adapter.deleteItem(i);
                    }
                }

                // 모든 선택 상태 초기화.
                //listview.clearChoices() ;

                adapter.notifyDataSetChanged();
            }
        }) ;



    }
}
//        // 빈 데이터 리스트 생성.
//        ArrayList<String> items = new ArrayList<String>();
//        // ArrayAdapter 생성. 아이템 View를 선택(multiple choice)가능하도록 만듦.
//        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.line, R.id.checkBox, items) ;
//
//        // listview 생성 및 adapter 지정.
//        ListView listview = (ListView) findViewById(R.id.listview) ;
//        listview.setAdapter(adapter) ;
//
//
//        // add button에 대한 이벤트 처리.
//        Button addButton = (Button)findViewById(R.id.add) ;
//        addButton.setOnClickListener(new Button.OnClickListener() {
//            public void onClick(View v) {
//                int count;
//                count = adapter.getCount();
//
//                // 아이템 추가.
//                items.add("LIST" + Integer.toString(count + 1));
//
//                // listview 갱신
//                adapter.notifyDataSetChanged();
//            }
//        }) ;
//
//        // delete button에 대한 이벤트 처리.
//        Button deleteButton = (Button)findViewById(R.id.delete) ;
//        deleteButton.setOnClickListener(new Button.OnClickListener() {
//            public void onClick(View v) {
//                SparseBooleanArray checkedItems = listview.getCheckedItemPositions();
//                int count = adapter.getCount() ;
//
//                for (int i = count-1; i >= 0; i--) {
//                    if (checkedItems.get(i)) {
//                        items.remove(i) ;
//                    }
//                }
//
//                // 모든 선택 상태 초기화.
//                listview.clearChoices() ;
//
//                adapter.notifyDataSetChanged();
//            }
//        }) ;
//
//        // selectAll button에 대한 이벤트 처리.
//        Button selectAllButton = (Button)findViewById(R.id.selectAll) ;
//        selectAllButton.setOnClickListener(new Button.OnClickListener() {
//            public void onClick(View v) {
//                int count = 0 ;
//                count = adapter.getCount() ;
//
//                for (int i=0; i<count; i++) {
//                    listview.setItemChecked(i, true) ;
//                }
//            }
//        }) ;
//    }




//
//    // ListView 사용
//    // (1) ListView 객체화
//    ListView list = new ListView(this);
//    // (2) ListView 에 공급될 데이터 정의
//
//    String[] items = {"감자", "고구마", "사과"};
//    // (3) ListView - Data 중계를 위한 Adapter 생성
//    // i. ListView에 데이터 공급      ii. ListView 한 줄의 모양을 결정
//    ArrayAdapter adapter = new ArrayAdapter(this,           // array 읽응 adapter
//            R.layout.line,                          // 한 줄의 모양
//            R.id.checkBox,                            // 공급되는 데이터를 보여줄 위치 ( 밑과는 달리, 셋 중 하나 골라줘야함)
//            items                                     // 곱급되는 데이터
//    );
//
//
//// (4) Adapter를 ListView에 연동(설정)
//        list.setAdapter(adapter);
//
//
//                setContentView(list);
//        ArrayAdapter adapter = new ArrayAdapter(this,           // array 읽응 adapter
//                android.R.layout.simple_list_item_1,    // 한 줄의 모양
//                str                                     // 곱급되는 데이터
//        );