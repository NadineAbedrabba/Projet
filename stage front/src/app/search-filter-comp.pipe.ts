import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'searchFilterComp'
})
export class SearchFilterCompPipe implements PipeTransform {

  transform(value: unknown, ...args: unknown[]): unknown {
    return null;
  }

}
