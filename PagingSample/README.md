# Android Paging Library Sample
Sample app demonstrating paging library (feat. MVVM, RxJava, Dagger, Glide)

## Demo
<div>
    <img src="https://github.com/ferrarijh/android-sample-projects/blob/master/PagingSample/demo/demo_paging.gif">
</div>

### Solved Issues
* `loadAfter()` from `ImageDataSource` not called

In method `onBindViewHolder()` in adapter class which extends `PagedListAdapter<>`,
use `getItem(position)` instead of `currentList.get(position)`. (`loadAfter()` is invoked in `getItem()`)