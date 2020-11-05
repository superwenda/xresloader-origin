/**
 * This file is generated by xresloader 2.10.0, please don't edit it.
 * You can find more information about this xresloader on https://xresloader.atframe.work/ .
 * If there is any problem, please find or report issues on https://github.com/xresloader/xresloader/issues .
 */
// Test arr_in_arr_cfg

#include "Config/ArrInArrCfg.h"



UArrInArrCfgHelper::UArrInArrCfgHelper() : Super()
{
    UArrInArrCfgHelper::ClearRow(this->Empty);
    this->Loader = MakeShareable(new ConstructorHelpers::FObjectFinder<UDataTable>(TEXT("DataTable'/Game/Config/ArrInArrCfg'")));
    if (this->Loader && this->Loader->Succeeded())
    {
        this->DataTable = this->Loader->Object;
        this->DataTable->OnDataTableChanged().AddUObject(this, &UArrInArrCfgHelper::OnReload);
        OnReload();
    }
    else
    {
        this->DataTable = nullptr;
    }
}

void UArrInArrCfgHelper::OnReload()
{
    // TODO Rebuild Index
}

FName UArrInArrCfgHelper::GetRowName(int32 Id)
{
    return *FString::Printf(TEXT("%lld"), static_cast<long long>(Id));
}

FName UArrInArrCfgHelper::GetDataRowName(int32 Id) const
{
    return UArrInArrCfgHelper::GetRowName(Id);
}

FName UArrInArrCfgHelper::GetTableRowName(const FArrInArrCfg& TableRow) const
{
    return GetDataRowName(TableRow.Id);
}

const FArrInArrCfg& UArrInArrCfgHelper::GetDataRowByName(const FName& Name, bool& IsValid) const
{
    IsValid = false;
    if (!this->DataTable) {
        return this->Empty;
    }

    FString Context;
    FArrInArrCfg* LookupRow = DataTable->FindRow<FArrInArrCfg>(Name, Context, false);
    if (!LookupRow) {
        return this->Empty;
    };

    IsValid = true;
    return *LookupRow;
}

const FArrInArrCfg& UArrInArrCfgHelper::GetDataRowByKey(int32 Id, bool& IsValid) const
{
    return GetDataRowByName(GetDataRowName(Id), IsValid);
}

bool UArrInArrCfgHelper::ForeachRow(TFunctionRef<void (const FName& Key, const FArrInArrCfg& Value)> Predicate) const
{
    if (!this->DataTable) {
        return false;
    }

    FString Context;
    this->DataTable->ForeachRow(Context, Predicate);
    return true;
}

UDataTable* UArrInArrCfgHelper::GetRawDataTable(bool& IsValid) const
{
    IsValid = false;
    if (!this->DataTable) {
        return NULL;
    }

    IsValid = true;
    return this->DataTable;
}

void UArrInArrCfgHelper::ClearRow(FArrInArrCfg& TableRow)
{
    TableRow.Name = TEXT("");
    TableRow.Id = 0;
    TableRow.Arr_0_Name = TEXT("");
    TableRow.Arr_0_IntArr_0 = 0;
    TableRow.Arr_0_IntArr_1 = 0;
    TableRow.Arr_0_StrArr_0 = TEXT("");
    TableRow.Arr_0_StrArr_1 = TEXT("");
    TableRow.Arr_1_Name = TEXT("");
    TableRow.Arr_1_IntArr_0 = 0;
    TableRow.Arr_1_IntArr_1 = 0;
    TableRow.Arr_1_StrArr_0 = TEXT("");
    TableRow.Arr_1_StrArr_1 = TEXT("");
    TableRow.TestMapIs_0_Key = 0;
    TableRow.TestMapIs_0_Value = TEXT("");
    TableRow.TestMapIs_1_Key = 0;
    TableRow.TestMapIs_1_Value = TEXT("");
}

void UArrInArrCfgHelper::ClearDataRow(FArrInArrCfg& TableRow) const
{
    UArrInArrCfgHelper::ClearRow(TableRow);
}

