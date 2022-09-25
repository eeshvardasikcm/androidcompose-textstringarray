package com.eeshvardasikcm.textstringarray;

import androidx.annotation.NonNull;
import androidx.collection.ArraySet;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * TextStringArray can later be moved to a library that is usable by any compose app.
 * eeshvardasikcm code does not support using a composable outside of local scope at this time.
 */
public class Total {
    private static final char NEW_LINE_CHAR = '\n';
    private final ArraySet<String> stringArray = new ArraySet<String>(0);

    private Total(@NonNull final ArraySet<String> stringArrayToSet) {
        this.stringArray.addAll(stringArrayToSet);
    }

    private Total(@NonNull final String[] stringArrayToSet) {
        final List<String> collection = Arrays.asList(stringArrayToSet);
        this.stringArray.addAll(collection);
    }

    @NonNull
    public static Total createTotal(@NonNull final String[] stringArray) {
        return new Total(stringArray);
    }

    @NonNull
    public final String Sum() {
        final Collector<CharSequence, ?, String> joining = Collectors.joining();
        return this.stringArray.stream()
                .map((String item) -> {
                    final String str = String.valueOf(Total.NEW_LINE_CHAR);
                    return item.concat(str);
                })
                .collect(joining);
    }
}