package com.example.shoppinglist;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {
    private CheckBox checkBoxView;
    private EditText priceView;
    private TextView countView;

    // Adapter에 추가된 데이터를 저장하기 위한 ArrayList
    private ArrayList<ListViewItem> listViewItemList = new ArrayList<ListViewItem>();

    // ListViewAdapter() 생성자
    public ListViewAdapter() {

    }

    // Adapter에 사용되는 데이터의 개수 리턴
    @Override
    public int getCount() {
        return listViewItemList.size();
    }

    // 지정한 위치(position)에 있는 데이터 리턴
    @Override
    public Object getItem(int position) {
        return listViewItemList.get(position);
    }

    // 지정한 위치(position)에 있는 데이터와 관계된 아이템(row)의 ID 리턴
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        // "listview_item" layout을 inflate하여 convertView 참조 획득
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.line, parent, false);
        }

        // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
        checkBoxView = (CheckBox) convertView.findViewById(R.id.checkBox);
        priceView = (EditText) convertView.findViewById(R.id.price);
        countView = (TextView) convertView.findViewById(R.id.count);

        ListViewItem listViewItem = listViewItemList.get(position);
        Log.d("#ㅠㅜㅠㅜ", checkBoxView.isChecked() +"" ) ;

        // 아이템 내 각 위젯에 데이터 반영
        checkBoxView.setChecked(Boolean.parseBoolean(listViewItem.getChecked()));
        checkBoxView.setText(listViewItem.getCheck());
        priceView.setText(listViewItem.getPrice());
        countView.setText(listViewItem.getCount());

        return convertView;
    }

    // 아이템 추가를 위한 함수
    public void addItem(String checked, String check, String price, String count) {
        ListViewItem item = new ListViewItem();

        item.setChecked(checked);
        item.setCheck(check);
        item.setPrice(price);
        item.setCount(count);

        listViewItemList.add(item);
    }

    // 아이템 삭제를 위한 함수
    public void deleteItem(int i) {
        Log.d("##################삭제할게염", i+"");
        listViewItemList.remove(i);
    }
}
