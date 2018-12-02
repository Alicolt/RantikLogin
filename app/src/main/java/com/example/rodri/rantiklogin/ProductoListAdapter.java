package com.example.rodri.rantiklogin;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Quoc Nguyen on 13-Dec-16.
 */

public class ProductoListAdapter extends BaseAdapter {

    private Context context;
    private  int layout;
    private ArrayList<Producto> productosList;

    public ProductoListAdapter(Context context, int layout, ArrayList<Producto> foodsList) {
        this.context = context;
        this.layout = layout;
        this.productosList = foodsList;
    }

    @Override
    public int getCount() {
        return productosList.size();
    }

    @Override
    public Object getItem(int position) {
        return productosList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder{
        ImageView imageView;
        TextView txtName, txtDesc, txtPrice, txtPlace, txtTime;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        View row = view;
        ViewHolder holder = new ViewHolder();

        if(row == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layout, null);

            holder.txtName = (TextView) row.findViewById(R.id.txtName);
            holder.txtDesc = (TextView) row.findViewById(R.id.txtDesc);
            holder.txtPrice = (TextView) row.findViewById(R.id.txtDesc);
            holder.txtPlace = (TextView) row.findViewById(R.id.txtPlace);
            holder.txtTime = (TextView) row.findViewById(R.id.txtTime);
            holder.imageView = (ImageView) row.findViewById(R.id.imgFood);
            row.setTag(holder);
        }
        else {
            holder = (ViewHolder) row.getTag();
        }

        Producto producto = productosList.get(position);

        holder.txtName.setText(producto.getName());
        holder.txtDesc.setText(producto.getDesc());
        holder.txtPrice.setText(producto.getPrice());
        holder.txtPlace.setText(producto.getPlace());
        holder.txtTime.setText(producto.getTime());

        byte[] productoImage = producto.getImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(productoImage, 0, productoImage.length);
        holder.imageView.setImageBitmap(bitmap);

        return row;
    }
}
