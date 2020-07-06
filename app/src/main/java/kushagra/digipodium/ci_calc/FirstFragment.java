package kushagra.digipodium.ci_calc;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class FirstFragment extends Fragment {

    private EditText prin;
    private EditText rate;
    private EditText comp;
    private EditText years;
    private Button btnCalc;
    double p1;
    double r1;
    double c1;
    double y1;
    double ci;
    double ci1;
    double amt;
    private TextView compint;
    private TextView amount;
    private Button btnReset;
    double f=0.0;


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        prin = view.findViewById(R.id.Prin);
        rate = view.findViewById(R.id.rate);
        comp = view.findViewById(R.id.comp);
        years = view.findViewById(R.id.years);
        btnCalc = view.findViewById(R.id.btnCalc);
        btnReset = view.findViewById(R.id.btnReset);
        compint = view.findViewById(R.id.compint);
        amount = view.findViewById(R.id.amount);
btnCalc.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String p = prin.getText().toString();
        String r = rate.getText().toString();
        String c = comp.getText().toString();
        String y = years.getText().toString();
        if (p.length() == 0) {
            Toast.makeText(getActivity(), "Enter Principle Amount", Toast.LENGTH_SHORT).show();
        }
        if (r.length() == 0) {
            Toast.makeText(getActivity(), "Enter Rate", Toast.LENGTH_SHORT).show();
        }
        if (c.length() == 0) {
            Toast.makeText(getActivity(), "Enter n", Toast.LENGTH_SHORT).show();
        }
        if (y.length() == 0) {
            Toast.makeText(getActivity(), "Enter No of Years", Toast.LENGTH_SHORT).show();
        } else {
            p1 = Double.parseDouble(p);
            r1 = Double.parseDouble(r);
            y1 = Double.parseDouble(y);
            c1 = Double.parseDouble(c);
            ci = p1 * Math.pow(1 + ((r1 / 100) / c1), c1 * y1);
            double am1 = ci - p1;

            compint.setText(String.valueOf(am1));
            amount.setText(String.valueOf(ci));
        }
    }
});
btnReset.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        prin.setText(String.valueOf(f));
        rate.setText(String.valueOf(f));
        comp.setText(String.valueOf(f));
        years.setText(String.valueOf(f));
        compint.setText(String.valueOf(f));
        amount.setText(String.valueOf(f));

    }
});
    }
}
