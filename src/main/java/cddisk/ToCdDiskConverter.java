package cddisk;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ToCdDiskConverter {

    public List<CdDisk> convert(List<Map<String, String>> data) {
        return data.stream()
            .map(datum -> {
                final String price = datum.get("price");
                final String year = datum.get("year");
                final String title = datum.get("title");
                final String artist = datum.get("artist");
                final String country = datum.get("country");
                final String company = datum.get("company");
                return new CdDisk(title, artist, country, company, price, year);
            })
            .collect(Collectors.toList());
    }
}
