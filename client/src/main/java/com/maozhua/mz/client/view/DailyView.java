package com.maozhua.mz.client.view;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DailyView {
    private String id;
    private String title;
    private String content;
    private String subtitle;
    private Long publicationDate;
    private List<String> imageList;
}