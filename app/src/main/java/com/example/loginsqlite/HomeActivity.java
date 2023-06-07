package com.example.loginsqlite;

        import androidx.appcompat.app.AppCompatActivity;
        import androidx.core.app.ActivityCompat;
        import androidx.core.content.ContextCompat;

        import android.Manifest;
        import android.annotation.SuppressLint;
        import android.content.pm.PackageManager;
        import android.location.Address;
        import android.location.Geocoder;
        import android.location.Location;
        import android.location.LocationListener;
        import android.location.LocationManager;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;
        import android.widget.Toast;

        import java.text.DecimalFormat;
        import java.util.List;
        import java.util.Locale;

public class HomeActivity extends AppCompatActivity implements LocationListener {

    Button button_location;
    TextView textView_location;
    LocationManager locationManager;
    private TextView totalPriceTextView;
    private TextView item1QuantityTextView;
    private TextView item2QuantityTextView;
    private TextView item3QuantityTextView;
    private TextView item4QuantityTextView;
    private TextView item5QuantityTextView;
    private TextView item6QuantityTextView;
    private TextView item7QuantityTextView;
    private int item1Quantity = 0;
    private int item2Quantity = 0;
    private int item3Quantity = 0;
    private int item4Quantity = 0;
    private int item5Quantity = 0;
    private int item6Quantity = 0;
    private int item7Quantity = 0;
    private double item1Cost = 6.0; // Adjust the item price as per your requirements
    private double item2Cost = 10.00; // Adjust the item price as per your requirements
    private double item3Cost = 4.0;
    private double item4Cost = 8.0;
    private double item5Cost = 8.0;
    private double item6Cost = 14.0;
    private double item7Cost = 18.0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        textView_location = findViewById(R.id.text_location);
        button_location = findViewById(R.id.button_location);
        totalPriceTextView = findViewById(R.id.totalPriceTextView);

        item1QuantityTextView = findViewById(R.id.item1QuantityTextView);
        item2QuantityTextView = findViewById(R.id.item2QuantityTextView);
        item3QuantityTextView = findViewById(R.id.item3QuantityTextView);
        item4QuantityTextView = findViewById(R.id.item4QuantityTextView);
        item5QuantityTextView = findViewById(R.id.item5QuantityTextView);
        item6QuantityTextView = findViewById(R.id.item6QuantityTextView);
        item7QuantityTextView = findViewById(R.id.item7QuantityTextView);
        Button item1AddButton = findViewById(R.id.item1AddButton);
        Button item1SubtractButton = findViewById(R.id.item1SubtractButton);
        Button item2AddButton = findViewById(R.id.item2AddButton);
        Button item2SubtractButton = findViewById(R.id.item2SubtractButton);
        Button item3AddButton = findViewById(R.id.item3AddButton);
        Button item3SubtractButton = findViewById(R.id.item3SubtractButton);
        Button item4AddButton = findViewById(R.id.item4AddButton);
        Button item4SubtractButton = findViewById(R.id.item4SubtractButton);
        Button item5AddButton = findViewById(R.id.item5AddButton);
        Button item5SubtractButton = findViewById(R.id.item5SubtractButton);
        Button item6AddButton = findViewById(R.id.item6AddButton);
        Button item6SubtractButton = findViewById(R.id.item6SubtractButton);
        Button item7AddButton = findViewById(R.id.item7AddButton);
        Button item7SubtractButton = findViewById(R.id.item7SubtractButton);

        //Runtime permissions
        if (ContextCompat.checkSelfPermission(HomeActivity.this, android.Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(HomeActivity.this,new String[]{
                    Manifest.permission.ACCESS_FINE_LOCATION
            },100);
        }


        button_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //create method
                getLocation();
            }
        });

        item1AddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item1Quantity++;
                updateItemQuantityAndCost(item1Quantity, item1Cost, item1QuantityTextView);
                calculateTotalPrice();
            }
        });

        item1SubtractButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (item1Quantity > 0) {
                    item1Quantity--;
                    updateItemQuantityAndCost(item1Quantity, item1Cost, item1QuantityTextView);
                    calculateTotalPrice();
                }
            }
        });

        item2AddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item2Quantity++;
                updateItemQuantityAndCost(item2Quantity, item2Cost, item2QuantityTextView);
                calculateTotalPrice();
            }
        });

        item2SubtractButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (item2Quantity > 0) {
                    item2Quantity--;
                    updateItemQuantityAndCost(item2Quantity, item2Cost, item2QuantityTextView);
                    calculateTotalPrice();
                }
            }
        });
        item3AddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item3Quantity++;
                updateItemQuantityAndCost(item3Quantity, item3Cost, item3QuantityTextView);
                calculateTotalPrice();
            }
        });

        item3SubtractButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (item3Quantity > 0) {
                    item3Quantity--;
                    updateItemQuantityAndCost(item3Quantity, item3Cost, item3QuantityTextView);
                    calculateTotalPrice();
                }
            }
        });
        item4AddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item4Quantity++;
                updateItemQuantityAndCost(item4Quantity, item4Cost, item4QuantityTextView);
                calculateTotalPrice();
            }
        });

        item4SubtractButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (item4Quantity > 0) {
                    item4Quantity--;
                    updateItemQuantityAndCost(item4Quantity, item4Cost, item4QuantityTextView);
                    calculateTotalPrice();
                }
            }
        });
        item5AddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item5Quantity++;
                updateItemQuantityAndCost(item5Quantity, item5Cost, item5QuantityTextView);
                calculateTotalPrice();
            }
        });

        item5SubtractButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (item5Quantity > 0) {
                    item5Quantity--;
                    updateItemQuantityAndCost(item5Quantity, item5Cost, item5QuantityTextView);
                    calculateTotalPrice();
                }
            }
        });
        item6AddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item6Quantity++;
                updateItemQuantityAndCost(item6Quantity, item6Cost, item6QuantityTextView);
                calculateTotalPrice();
            }
        });

        item6SubtractButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (item6Quantity > 0) {
                    item6Quantity--;
                    updateItemQuantityAndCost(item6Quantity, item6Cost, item6QuantityTextView);
                    calculateTotalPrice();
                }
            }
        });
        item7AddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item7Quantity++;
                updateItemQuantityAndCost(item7Quantity, item7Cost, item7QuantityTextView);
                calculateTotalPrice();
            }
        });

        item7SubtractButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (item7Quantity > 0) {
                    item7Quantity--;
                    updateItemQuantityAndCost(item7Quantity, item7Cost, item7QuantityTextView);
                    calculateTotalPrice();
                }
            }
        });
    }

    @SuppressLint("MissingPermission")
    private void getLocation() {

        try {
            locationManager = (LocationManager) getApplicationContext().getSystemService(LOCATION_SERVICE);
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,5000,5,HomeActivity.this);

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void onLocationChanged(Location location) {
        Toast.makeText(this, ""+location.getLatitude()+","+location.getLongitude(), Toast.LENGTH_SHORT).show();
        try {
            Geocoder geocoder = new Geocoder(HomeActivity.this, Locale.getDefault());
            List<Address> addresses = geocoder.getFromLocation(location.getLatitude(),location.getLongitude(),1);
            String address = addresses.get(0).getAddressLine(0);

            textView_location.setText(address);

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
    private void updateItemQuantityAndCost(int quantity, double cost, TextView quantityTextView) {
        quantityTextView.setText(String.valueOf(quantity));
        DecimalFormat decimalFormat = new DecimalFormat("#.##");

    }

    private void calculateTotalPrice() {
        double totalPrice = (item1Quantity * item1Cost) + (item2Quantity * item2Cost)+(item3Quantity * item3Cost)+(item4Quantity * item4Cost)+(item5Quantity * item5Cost)+(item6Quantity * item6Cost)+(item7Quantity * item7Cost);
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        totalPriceTextView.setText("Total Price: $" + decimalFormat.format(totalPrice));
    }
}